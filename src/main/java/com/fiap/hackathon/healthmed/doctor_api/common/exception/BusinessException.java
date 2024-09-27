package com.fiap.hackathon.healthmed.doctor_api.common.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
