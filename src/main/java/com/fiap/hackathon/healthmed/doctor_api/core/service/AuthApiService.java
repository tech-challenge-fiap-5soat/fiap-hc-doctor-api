package com.fiap.hackathon.healthmed.doctor_api.core.service;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Login;

public interface AuthApiService {

    Boolean createCredentials(Doctor doctor);

    String login(Login login);
}
