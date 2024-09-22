package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

public record DoctorCreateRequest(
        String name,
        String cpf,
        String crm,
        String email,
        String password) {
}
