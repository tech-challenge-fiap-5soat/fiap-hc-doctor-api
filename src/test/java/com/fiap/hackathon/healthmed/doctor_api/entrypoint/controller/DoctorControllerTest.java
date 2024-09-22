package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller;

import com.fiap.hackathon.healthmed.doctor_api.core.service.DoctorService;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.impl.DoctorControllerImpl;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequestTestUtils.getDoctorCreateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponseTestUtils.getDoctorResponse;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponseTestUtils.getDoctorResponseAsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorControllerImpl doctorController;

    @Test
    void testCreateSuccessful() {
        // Arrange
        DoctorCreateRequest request = getDoctorCreateRequest();
        DoctorResponse expectedResponse = getDoctorResponse();

        when(doctorService.createDoctor(request)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<DoctorResponse> actualResponse = doctorController.create(request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(CREATED, actualResponse.getStatusCode());
        assertEquals(expectedResponse, actualResponse.getBody());
        verify(doctorService).createDoctor(request);
    }

    @Test
    void testFindAllSuccessful() {
        // Arrange
        List<DoctorResponse> expectedResponses = getDoctorResponseAsList();

        when(doctorService.findAllDoctors()).thenReturn(expectedResponses);

        // Act
        ResponseEntity<List<DoctorResponse>> actualResponse = doctorController.findAll();

        // Assert
        assertNotNull(actualResponse);
        assertEquals(OK, actualResponse.getStatusCode());
        assertEquals(expectedResponses.size(), actualResponse.getBody().size());
        verify(doctorService).findAllDoctors();
    }
}