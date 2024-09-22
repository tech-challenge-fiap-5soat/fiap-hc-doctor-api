package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller;

import com.fiap.hackathon.healthmed.doctor_api.core.service.AppointmentService;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.impl.AppointmentControllerImpl;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDON_UUID;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequestTestUtils.getAppointmentCreateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequestTestUtils.getAppointmentUpdateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponseTestUtils.getAppointmentResponse;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponseTestUtils.getAppointmentResponseAsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {
    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentControllerImpl appointmentController;

    @Test
    void testCreateSuccessful() {
        // Arrange
        AppointmentCreateRequest request = getAppointmentCreateRequest();
        AppointmentResponse expectedResponse = getAppointmentResponse();

        when(appointmentService.createAppointment(any(AppointmentCreateRequest.class))).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AppointmentResponse> actualResponse = appointmentController.create(request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(CREATED, actualResponse.getStatusCode());
        assertEquals(expectedResponse, actualResponse.getBody());
        verify(appointmentService).createAppointment(request);
    }

    @Test
    void testUpdateSuccessful() {
        // Arrange
        AppointmentUpdateRequest request = getAppointmentUpdateRequest();
        AppointmentResponse expectedResponse = getAppointmentResponse();


        when(appointmentService.updateAppointment(any(UUID.class), any(AppointmentUpdateRequest.class))).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AppointmentResponse> actualResponse = appointmentController.update(RANDON_UUID, request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(OK, actualResponse.getStatusCode());
        assertEquals(expectedResponse, actualResponse.getBody());
        verify(appointmentService).updateAppointment(RANDON_UUID, request);
    }

    @Test
    void testGetDoctorAppointmentsSuccessful() {
        // Arrange
        UUID doctorId = UUID.randomUUID();
        List<AppointmentResponse> expectedResponses = getAppointmentResponseAsList();

        when(appointmentService.findAllAppointmentsByDoctorId(doctorId)).thenReturn(expectedResponses);

        // Act
        ResponseEntity<List<AppointmentResponse>> actualResponse = appointmentController.getDoctorAppointments(doctorId);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(OK, actualResponse.getStatusCode());
        assertEquals(expectedResponses.size(), actualResponse.getBody().size());
        verify(appointmentService).findAllAppointmentsByDoctorId(doctorId);
    }
}