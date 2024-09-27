package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DoctorCreateRequest(
        @NotNull
        String name,
        @NotNull
        String cpf,
        @NotNull
        String crm,
        @Email
        String email,
        @NotNull
        String password) {
}
