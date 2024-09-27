package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponse(
        UUID id,
        UUID doctorId,
        LocalDateTime date,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
