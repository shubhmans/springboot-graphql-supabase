package com.streamlineideas.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Simple DTO to represent an error payload.
 */
@Getter
@Setter
public class ErrorDTO {
    private String code;
    private String message;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

