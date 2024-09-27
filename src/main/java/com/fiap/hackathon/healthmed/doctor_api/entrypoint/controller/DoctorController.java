package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller;

import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorLoginRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.PathConstants.DOCTOR;
import static com.fiap.hackathon.healthmed.doctor_api.common.constants.PathConstants.DOCTOR_LOGIN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = DOCTOR, produces = APPLICATION_JSON_VALUE)
public interface DoctorController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<DoctorResponse> create(@RequestBody DoctorCreateRequest request);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<DoctorResponse>> findAll();

    @PostMapping(path = DOCTOR_LOGIN, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> login(@RequestBody DoctorLoginRequest request);
}
