package com.fiap.hackathon.healthmed.doctor_api.core.service;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.DoctorMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.service.impl.DoctorServiceImpl;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository.DoctorRepository;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDON_UUID;
import static com.fiap.hackathon.healthmed.doctor_api.core.domain.model.DoctorTestUtils.*;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequestTestUtils.getDoctorCreateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponseTestUtils.getDoctorResponse;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponseTestUtils.getDoctorResponseAsList;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @Mock
    private AuthApiService authApiService;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @Test
    void testCreateDoctor() {
        // Arrange
        DoctorCreateRequest request = getDoctorCreateRequest();
        Doctor expectedDoctor = getDoctor();
        DoctorResponse response = getDoctorResponse();

        when(doctorMapper.doctorCreateRequestToDoctor(any(DoctorCreateRequest.class))).thenReturn(expectedDoctor);
        when(doctorMapper.doctorToDoctorResponse(expectedDoctor)).thenReturn(response);
        when(doctorRepository.save(any(Doctor.class))).thenReturn(expectedDoctor);
        when(authApiService.createCredentials(expectedDoctor)).thenReturn(TRUE);

        // Act
        DoctorResponse actualResponse = doctorService.createDoctor(request);

        // Assert
        assertNotNull(actualResponse);
        verify(doctorRepository).save(any(Doctor.class));
    }

    @Test
    void testFindAllDoctors() {
        // Arrange
        List<Doctor> doctors = getDoctorAsList();
        when(doctorRepository.findAll()).thenReturn(doctors);
        when(doctorMapper.doctorListToDoctorResponseList(doctors)).thenReturn(getDoctorResponseAsList());

        // Act
        List<DoctorResponse> actualResponses = doctorService.findAllDoctors();

        // Assert
        assertNotNull(actualResponses);
        assertEquals(doctors.size(), actualResponses.size());
        verify(doctorRepository).findAll();
    }

    @Test
    void testFindDoctorByIdSuccessful() {
        // Arrange
        Optional<Doctor> optionalDoctor = getOptionalOfDoctor();
        when(doctorRepository.findById(RANDON_UUID)).thenReturn(optionalDoctor);

        // Act
        Optional<Doctor> actualOptionalDoctor = doctorService.findDoctorById(RANDON_UUID);

        // Assert
        assertTrue(actualOptionalDoctor.isPresent());
        verify(doctorRepository).findById(RANDON_UUID);
    }

    @Test
    void testFindDoctorByIdUnsuccessful() {
        // Arrange
        when(doctorRepository.findById(RANDON_UUID)).thenReturn(Optional.empty());

        // Act
        Optional<Doctor> actualOptionalDoctor = doctorService.findDoctorById(RANDON_UUID);

        // Assert
        assertFalse(actualOptionalDoctor.isPresent());
        verify(doctorRepository).findById(RANDON_UUID);
    }
}