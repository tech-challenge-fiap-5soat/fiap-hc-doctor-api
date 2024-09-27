package com.fiap.hackathon.healthmed.doctor_api.core.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;
import static com.fiap.hackathon.healthmed.doctor_api.core.domain.model.DoctorTestUtils.getDoctor;

public class AppointmentTestUtils {
    public static Appointment getAppointment() {
        return new Appointment(RANDON_UUID, getDoctor(), APPOINTMENT_DATE, APPOINTMENT_START_TIME, APPOINTMENT_END_TIME);
    }

    public static Optional<Appointment> getOptionalOfAppointment() {
        return Optional.of(getAppointment());
    }

    public static List<Appointment> getAppointmentsAsList() {
        return Arrays.asList(getAppointment());
    }
}