package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.impl;

import com.fiap.hackathon.healthmed.doctor_api.core.service.AppointmentService;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.AppointmentController;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorAppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AppointmentControllerImpl implements AppointmentController {

    private final AppointmentService service;

    @Override
    public ResponseEntity<Void> create(DoctorAppointmentCreateRequest request) {
        service.createAppointment(request);
        return status(CREATED).build();
    }

    @Override
    public ResponseEntity<AppointmentResponse> update(UUID appointmentId, AppointmentUpdateRequest request) {
        return status(OK).body(service.updateAppointment(appointmentId, request));
    }

    @Override
    public ResponseEntity<List<AppointmentResponse>> getDoctorAppointments(UUID doctorId) {
        return status(OK).body(service.findAllAppointmentsByDoctorId(doctorId));
    }
}
