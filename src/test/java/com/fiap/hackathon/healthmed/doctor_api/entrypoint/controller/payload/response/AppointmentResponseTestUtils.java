package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response;

import java.util.Arrays;
import java.util.List;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDOM_LOCAL_DATE_TIME;
import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDON_UUID;

public class AppointmentResponseTestUtils {
    public static AppointmentResponse getAppointmentResponse() {
        return new AppointmentResponse(RANDON_UUID, RANDON_UUID, RANDOM_LOCAL_DATE_TIME, RANDOM_LOCAL_DATE_TIME, RANDOM_LOCAL_DATE_TIME);
    }

    public static List<AppointmentResponse> getAppointmentResponseAsList() {
        return Arrays.asList(getAppointmentResponse());
    }
}