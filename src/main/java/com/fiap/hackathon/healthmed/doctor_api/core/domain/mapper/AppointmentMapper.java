package com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Appointment;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorScheduleRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    public abstract Appointment appointmentCreateRequestToAppointment(AppointmentCreateRequest request);
    @Mapping(target = "startTime", expression = "java(dateAndTimeToLocalDateTime(appointment.getDate(), appointment.getStartTime()))")
    @Mapping(target = "endTime", expression = "java(dateAndTimeToLocalDateTime(appointment.getDate(), appointment.getEndTime()))")
    @Mapping(target = "date", expression = "java(dateToLocalDateTime(appointment.getDate()))")
    @Mapping(target = "doctorId", source = "appointment.doctor.id")
    public abstract AppointmentResponse appointmentToAppointmentResponse(Appointment appointment);

    public abstract List<AppointmentResponse> appointmentListToAppointmentResponseList(List<Appointment> appointments);

    public abstract List<Appointment> appointmentCreateRequestListToAppointmentList(List<AppointmentCreateRequest> request);

    @Mapping(target = "startTime", expression = "java(dateAndTimeToLocalDateTime(appointment.getDate(), appointment.getStartTime()))")
    @Mapping(target = "endTime", expression = "java(dateAndTimeToLocalDateTime(appointment.getDate(), appointment.getEndTime()))")
    @Mapping(target = "date", expression = "java(dateToLocalDateTime(appointment.getDate()))")
    @Mapping(target = "doctorId", source = "appointment.doctor.id")
    public abstract CreateDoctorScheduleRequest appointmentToCreateDoctorScheduleRequest(Appointment appointment);

    public abstract List<CreateDoctorScheduleRequest> appointmentListToCreateDoctorScheduleRequestList(List<Appointment> appointments);

    protected LocalDateTime dateAndTimeToLocalDateTime(LocalDate date, LocalTime time) {
        if (date == null || time == null) {
            return null;
        }

        return date.atTime(time);
    }

    protected LocalDateTime dateToLocalDateTime(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.atStartOfDay();
    }
}
