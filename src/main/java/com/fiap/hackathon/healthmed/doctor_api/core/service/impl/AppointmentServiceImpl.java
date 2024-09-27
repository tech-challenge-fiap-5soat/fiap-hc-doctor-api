package com.fiap.hackathon.healthmed.doctor_api.core.service.impl;

import com.fiap.hackathon.healthmed.doctor_api.common.exception.BusinessException;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.AppointmentMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Appointment;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.service.AppointmentService;
import com.fiap.hackathon.healthmed.doctor_api.core.service.DoctorService;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.SchedulingApiClient;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorScheduleRequest;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository.AppointmentRepository;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorAppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper = Mappers.getMapper(AppointmentMapper.class);

    private final DoctorService doctorService;
    private final SchedulingApiClient schedulingApiClient;
    private static final String MESSAGE_DOCTOR_NOT_FOUND = "doctor not found";
    private static final String MESSAGE_APPOINTMENT_NOT_FOUND = "appointment not found";
    @Override
    public void createAppointment(DoctorAppointmentCreateRequest request) {
        Optional<Doctor> doctorOp = doctorService.findDoctorById(request.doctorId());

        if (doctorOp.isEmpty()) {
            throw new BusinessException(MESSAGE_DOCTOR_NOT_FOUND);
        }

        List<Appointment> appointments = mapper.appointmentCreateRequestListToAppointmentList(request.appointments());

        appointments.forEach(a -> {
            a.setDoctor(doctorOp.get());
        });

        List<Appointment> saved = repository.saveAll(appointments);
        sendAppointmentsToSchedulingApi(doctorOp.get().getId(), saved);
    }

    private void sendAppointmentsToSchedulingApi(UUID doctorId, List<Appointment> appointments) {
        List<CreateDoctorScheduleRequest> request = mapper.appointmentListToCreateDoctorScheduleRequestList(appointments);

        schedulingApiClient.createDoctor(doctorId, request);
    }

    @Override
    public AppointmentResponse updateAppointment(UUID appointmentId, AppointmentUpdateRequest request) {
        Optional<Appointment> appointmentOp = repository.findById(appointmentId);

        if (appointmentOp.isEmpty()) {
            throw new BusinessException(MESSAGE_APPOINTMENT_NOT_FOUND);
        }

        Appointment appointment = appointmentOp.get();
        appointment.setDate(request.date());
        appointment.setStartTime(request.startTime());
        appointment.setEndTime(request.endTime());

        Appointment saved = repository.save(appointment);

        return mapper.appointmentToAppointmentResponse(saved);
    }

    @Override
    public List<AppointmentResponse> findAllAppointmentsByDoctorId(UUID doctorId) {
        List<Appointment> appointments = repository.findAppointmentsByDoctorIdAndDateAndStartTime(doctorId, LocalDate.now(), LocalTime.now());

        return mapper.appointmentListToAppointmentResponseList(appointments);
    }
}
