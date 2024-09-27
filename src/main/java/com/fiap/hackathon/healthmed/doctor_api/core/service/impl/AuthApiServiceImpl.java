package com.fiap.hackathon.healthmed.doctor_api.core.service.impl;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.DoctorMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.LoginMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Login;
import com.fiap.hackathon.healthmed.doctor_api.core.service.AuthApiService;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.AuthApiClient;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorCredentialsRequest;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthApiServiceImpl implements AuthApiService {
    private final DoctorMapper doctorMapper;
    private final LoginMapper loginMapper;
    private final AuthApiClient authApiClient;
    @Override
    public Boolean createCredentials(Doctor doctor) {
        CreateDoctorCredentialsRequest credentialsRequest = doctorMapper.doctorToCreateDoctorCredentialsRequest(doctor);

        return authApiClient.createCredentials(credentialsRequest);
    }

    @Override
    public String login(Login login) {
        LoginRequest loginRequest = loginMapper.loginToLoginRequest(login);

        return authApiClient.login(loginRequest);
    }
}
