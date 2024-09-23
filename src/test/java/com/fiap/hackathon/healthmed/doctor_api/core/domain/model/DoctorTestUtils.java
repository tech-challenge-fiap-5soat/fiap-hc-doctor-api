package com.fiap.hackathon.healthmed.doctor_api.core.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;

public class DoctorTestUtils {

    public static Doctor getDoctor() {
        return new Doctor(RANDON_UUID, NAME, CPF, CRM, EMAIL, null, null, null, null);
    }

    public static Optional<Doctor> getOptionalOfDoctor() {
        return Optional.of(getDoctor());
    }

    public static List<Doctor> getDoctorAsList() {
        return Arrays.asList(getDoctor());
    }
}