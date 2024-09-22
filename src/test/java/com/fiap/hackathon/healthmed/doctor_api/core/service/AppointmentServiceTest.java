package com.fiap.hackathon.healthmed.doctor_api.core.service;

import com.fiap.hackathon.healthmed.doctor_api.common.exception.BusinessException;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper.AppointmentMapper;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Appointment;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.core.service.impl.AppointmentServiceImpl;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository.AppointmentRepository;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDON_UUID;
import static com.fiap.hackathon.healthmed.doctor_api.core.domain.model.AppointmentTestUtils.*;
import static com.fiap.hackathon.healthmed.doctor_api.core.domain.model.DoctorTestUtils.getOptionalOfDoctor;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequestTestUtils.getAppointmentCreateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentUpdateRequestTestUtils.getAppointmentUpdateRequest;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponseTestUtils.getAppointmentResponse;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.AppointmentResponseTestUtils.getAppointmentResponseAsList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private AppointmentMapper appointmentMapper;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Test
    void testCreateAppointmentSuccessful() {
        // Arrange
        AppointmentCreateRequest request = getAppointmentCreateRequest();
        Appointment appointment = getAppointment();

        Optional<Doctor> doctorOp = getOptionalOfDoctor();

        when(doctorService.findDoctorById(RANDON_UUID)).thenReturn(doctorOp);
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        // Act
        AppointmentResponse actualResponse = appointmentService.createAppointment(request);

        // Assert
        assertNotNull(actualResponse);
        verify(doctorService).findDoctorById(request.doctorId());
        verify(appointmentRepository).save(any(Appointment.class));
    }

    @Test
    void testCreateAppointmentDoctorNotFound() {
        // Arrange
        AppointmentCreateRequest request = getAppointmentCreateRequest();

        when(doctorService.findDoctorById(RANDON_UUID)).thenThrow(new BusinessException("doctor not found"));

        // Act & Assert
        assertThrows(BusinessException.class, () -> appointmentService.createAppointment(request));
        verify(doctorService).findDoctorById(request.doctorId());
    }

    @Test
    void testUpdateAppointmentSuccessful() {
        // Arrange
        AppointmentUpdateRequest request = getAppointmentUpdateRequest();
        AppointmentResponse response = getAppointmentResponse();
        Appointment appointment = getAppointment();
        Optional<Appointment> appointmentOp = getOptionalOfAppointment();

        when(appointmentRepository.findById(RANDON_UUID)).thenReturn(appointmentOp);
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        // Act
        AppointmentResponse actualResponse = appointmentService.updateAppointment(RANDON_UUID, request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(RANDON_UUID, actualResponse.id());
        verify(appointmentRepository).findById(RANDON_UUID);
        verify(appointmentRepository).save(appointment);
    }

    @Test
    void testUpdateAppointmentAppointmentNotFound() {
        // Arrange
        AppointmentUpdateRequest request = getAppointmentUpdateRequest();

        when(appointmentRepository.findById(RANDON_UUID)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BusinessException.class, () -> appointmentService.updateAppointment(RANDON_UUID, request));
        verify(appointmentRepository).findById(RANDON_UUID);
    }

    @Test
    void testFindAllAppointmentsByDoctorId() {
        // Arrange
        List<Appointment> appointments = getAppointmentsAsList();
        List<AppointmentResponse> expectedResponses = getAppointmentResponseAsList();

        when(appointmentRepository.findAppointmentsByDoctorIdAndDateAndStartTime(any(UUID.class), any(LocalDate.class), any(LocalTime.class))).thenReturn(appointments);

        // Act
        List<AppointmentResponse> actualResponses = appointmentService.findAllAppointmentsByDoctorId(RANDON_UUID);

        // Assert
        assertNotNull(actualResponses);
        assertEquals(expectedResponses.size(), actualResponses.size());
        verify(appointmentRepository).findAppointmentsByDoctorIdAndDateAndStartTime(any(UUID.class), any(LocalDate.class), any(LocalTime.class));
    }
}