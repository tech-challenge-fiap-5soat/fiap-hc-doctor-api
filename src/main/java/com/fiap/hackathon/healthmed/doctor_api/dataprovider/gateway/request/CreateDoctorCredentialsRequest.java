package com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request;

import com.fiap.hackathon.healthmed.doctor_api.common.enums.UserAuthType;

public record CreateDoctorCredentialsRequest(
        String name,
        String cpf,
        String crm,
        String email,
        String password,
        UserAuthType userType
) {
}
