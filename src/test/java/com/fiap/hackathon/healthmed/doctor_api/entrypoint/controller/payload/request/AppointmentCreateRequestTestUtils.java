package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import java.util.Arrays;
import java.util.List;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;

public class AppointmentCreateRequestTestUtils {

    public static AppointmentCreateRequest getAppointmentCreateRequest() {
        return new AppointmentCreateRequest(APPOINTMENT_DATE, APPOINTMENT_START_TIME, APPOINTMENT_END_TIME);
    }

    public static List<AppointmentCreateRequest> getAppointmentCreateRequestAsList() {
        return Arrays.asList(getAppointmentCreateRequest());
    }
}