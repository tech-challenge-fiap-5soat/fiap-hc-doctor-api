package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller;

import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorAppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.PathConstants.APPOINTMENTS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RequestMapping(path = APPOINTMENTS, produces = APPLICATION_JSON_VALUE)
public interface AppointmentController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@Valid @RequestBody DoctorAppointmentCreateRequest request);

    @PutMapping(path = "/{appointmentId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<AppointmentResponse> update(@PathVariable UUID appointmentId, @RequestBody AppointmentUpdateRequest request);

    @GetMapping(path = "/{doctorId}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AppointmentResponse>> getDoctorAppointments(@PathVariable UUID doctorId);
}
