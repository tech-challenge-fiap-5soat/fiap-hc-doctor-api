package com.fiap.hackathon.healthmed.doctor_api.core.service;

import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorAppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    void createAppointment(DoctorAppointmentCreateRequest request);

    AppointmentResponse updateAppointment(UUID appointmentId, AppointmentUpdateRequest request);

    List<AppointmentResponse> findAllAppointmentsByDoctorId(UUID doctorId);
}
