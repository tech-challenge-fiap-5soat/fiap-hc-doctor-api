package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record DoctorAppointmentCreateRequest(@NotNull UUID doctorId,
                                             @NotNull @Size(min = 1) List<@NotEmpty AppointmentCreateRequest> appointments) {
}
