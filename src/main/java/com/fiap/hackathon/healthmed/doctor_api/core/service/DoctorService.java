package com.fiap.hackathon.healthmed.doctor_api.core.service;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorLoginRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    DoctorResponse createDoctor(DoctorCreateRequest request);

    List<DoctorResponse> findAllDoctors();

    Optional<Doctor> findDoctorById(UUID doctorId);

    String loginAndGetAuthToken(DoctorLoginRequest request);
}
