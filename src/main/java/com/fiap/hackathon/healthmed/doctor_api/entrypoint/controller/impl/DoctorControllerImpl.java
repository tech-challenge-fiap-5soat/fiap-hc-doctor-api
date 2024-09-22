package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.impl;

import com.fiap.hackathon.healthmed.doctor_api.core.service.DoctorService;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.DoctorController;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DoctorControllerImpl implements DoctorController {

    private final DoctorService service;

    @Override
    public ResponseEntity<DoctorResponse> create(DoctorCreateRequest request) {
        return status(CREATED).body(service.createDoctor(request));
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> findAll() {
        return status(OK).body(service.findAllDoctors());
    }
}
