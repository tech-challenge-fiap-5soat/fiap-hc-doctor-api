package com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateDoctorScheduleRequest(
        UUID doctorId,
        LocalDateTime date,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
