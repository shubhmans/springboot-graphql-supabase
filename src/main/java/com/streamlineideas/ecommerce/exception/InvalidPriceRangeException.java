package com.streamlineideas.ecommerce.exception;

import com.streamlineideas.ecommerce.dto.ErrorDTO;

/**
 * Thrown when a provided price range is invalid (minPrice > maxPrice).
 */
public class InvalidPriceRangeException extends RuntimeException {
    private final ErrorDTO error;

    public InvalidPriceRangeException(String message) {
        super(message);
        this.error = new ErrorDTO("INVALID_PRICE_RANGE", message);
    }

    public InvalidPriceRangeException(ErrorDTO error) {
        super(error != null ? error.getMessage() : null);
        this.error = error;
    }

    public ErrorDTO getError() {
        return error;
    }
}

