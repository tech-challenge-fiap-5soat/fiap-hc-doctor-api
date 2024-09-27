package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response;

import java.util.UUID;

public record DoctorResponse(UUID id,
                             String name,
                             String crm,
                             String cpf,
                             String email) {
}
