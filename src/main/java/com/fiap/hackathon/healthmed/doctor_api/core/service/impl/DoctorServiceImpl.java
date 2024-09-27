package com.fiap.hackathon.healthmed.doctor_api.core.service.impl;

import com.fiap.hackathon.healthmed.doctor_api.common.exception.BusinessException;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.DoctorMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.LoginMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Login;
import com.fiap.hackathon.healthmed.doctor_api.core.service.AuthApiService;
import com.fiap.hackathon.healthmed.doctor_api.core.service.DoctorService;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository.DoctorRepository;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorLoginRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;
    private final LoginMapper loginMapper;
    private final AuthApiService authApiService;

    private static final String MESSAGE_ERROR_CREATE_CREDENTIALS = "Error creating Doctor auth credentials";
    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {
        Doctor doctor = mapper.doctorCreateRequestToDoctor(request);

        createDoctorCredentials(doctor);

        Doctor saved = repository.save(doctor);

        return mapper.doctorToDoctorResponse(saved);
    }

    private void createDoctorCredentials(Doctor doctor) {
        Boolean authCreated = authApiService.createCredentials(doctor);

        if (!authCreated) {
            throw new BusinessException(MESSAGE_ERROR_CREATE_CREDENTIALS);
        }
    }

    @Override
    public List<DoctorResponse> findAllDoctors() {
        List<Doctor> allDoctors = repository.findAll();

        return mapper.doctorListToDoctorResponseList(allDoctors);
    }

    @Override
    public Optional<Doctor> findDoctorById(UUID doctorId) {
        return repository.findById(doctorId);
    }

    @Override
    public String loginAndGetAuthToken(DoctorLoginRequest request) {
        Login login = loginMapper.doctorLoginRequestToLogin(request);

        return authApiService.login(login);
    }
}
