package com.fiap.hackathon.healthmed.doctor_api.common.constants;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@UtilityClass
public class TestsConstants {

    public static final UUID RANDON_UUID = UUID.randomUUID();
    public static final String NAME = "Joao das couves";
    public static final String CPF = "012345678900";
    public static final String CRM = "CRM123456";
    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final LocalDate APPOINTMENT_DATE = LocalDate.of(2025, 10, 10);
    public static final LocalTime APPOINTMENT_START_TIME = LocalTime.of(13,00);
    public static final LocalTime APPOINTMENT_END_TIME = LocalTime.of(14,00);
    public static final LocalDateTime RANDOM_LOCAL_DATE_TIME = LocalDateTime.of(2025, 10, 10, 13, 00, 00);
}