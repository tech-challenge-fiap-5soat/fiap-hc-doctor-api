package com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Login;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.LoginRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorLoginRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginRequest loginToLoginRequest(Login login);

    Login doctorLoginRequestToLogin(DoctorLoginRequest request);
}
