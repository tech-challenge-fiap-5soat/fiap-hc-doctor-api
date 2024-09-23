package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

public record DoctorLoginRequest(
        String email,
        String password
) {
}
