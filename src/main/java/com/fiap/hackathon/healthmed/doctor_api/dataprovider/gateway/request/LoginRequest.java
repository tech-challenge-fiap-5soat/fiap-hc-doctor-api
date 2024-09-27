package com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request;

public record LoginRequest(
        String email,
        String password
) {
}
