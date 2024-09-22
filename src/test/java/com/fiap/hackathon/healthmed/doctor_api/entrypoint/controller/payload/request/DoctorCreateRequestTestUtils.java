package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;

public class DoctorCreateRequestTestUtils {
    public static DoctorCreateRequest getDoctorCreateRequest() {
        return new DoctorCreateRequest(NAME, CPF, CRM, EMAIL, PASSWORD);
    }
}