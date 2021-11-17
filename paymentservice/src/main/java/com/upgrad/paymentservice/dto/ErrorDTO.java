package com.upgrad.paymentservice.dto;

public class ErrorDTO {
    private String message;
    private String errorDetails;

    public ErrorDTO(String message, String errorDetails) {
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
