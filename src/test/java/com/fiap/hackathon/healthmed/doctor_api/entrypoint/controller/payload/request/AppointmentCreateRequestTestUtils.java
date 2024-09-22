package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.*;

public class AppointmentCreateRequestTestUtils {

    public static AppointmentCreateRequest getAppointmentCreateRequest() {
        return new AppointmentCreateRequest(RANDON_UUID, APPOINTMENT_DATE, APPOINTMENT_START_TIME, APPOINTMENT_END_TIME);
    }
}