package com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request;

import static com.fiap.hackathon.healthmed.doctor_api.common.constants.TestsConstants.RANDON_UUID;
import static com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.AppointmentCreateRequestTestUtils.getAppointmentCreateRequestAsList;

public class DoctorAppointmentCreateRequestTestUtils {

    public static DoctorAppointmentCreateRequest getDoctorAppointmentCreateRequest() {
        return new DoctorAppointmentCreateRequest(RANDON_UUID, getAppointmentCreateRequestAsList());
    }
}