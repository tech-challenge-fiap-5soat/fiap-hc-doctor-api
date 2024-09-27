package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentUpdateRequest(
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @NotNull
        LocalDate date,
        @JsonDeserialize(using = LocalTimeDeserializer.class)
        @JsonSerialize(using = LocalTimeSerializer.class)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        @NotNull
        LocalTime startTime,
        @JsonDeserialize(using = LocalTimeDeserializer.class)
        @JsonSerialize(using = LocalTimeSerializer.class)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        @NotNull
        LocalTime endTime) {

}
