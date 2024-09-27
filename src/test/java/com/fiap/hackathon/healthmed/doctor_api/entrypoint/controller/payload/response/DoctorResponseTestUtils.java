package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response;

import java.util.Arrays;
import java.util.List;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;

public class DoctorResponseTestUtils {
    public static DoctorResponse getDoctorResponse() {
        return new DoctorResponse(RANDON_UUID, NAME, CRM, CPF, EMAIL);
    }

    public static List<DoctorResponse> getDoctorResponseAsList() {
        return Arrays.asList(getDoctorResponse());
    }
}