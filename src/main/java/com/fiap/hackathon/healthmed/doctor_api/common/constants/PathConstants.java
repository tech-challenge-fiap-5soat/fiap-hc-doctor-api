package com.fiap.hackathon.healthmed.doctor_api.common.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {

    private static final String API_VERSION = "/v1";
    public static final String DOCTOR = API_VERSION + "/doctor";
    public static final String APPOINTMENTS = API_VERSION + "/appointments";
    public static final String DOCTOR_LOGIN =  "/authorization";
}
