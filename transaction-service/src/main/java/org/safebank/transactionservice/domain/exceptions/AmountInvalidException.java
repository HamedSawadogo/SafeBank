package org.safebank.transactionservice.domain.exceptions;

public class AmountInvalidException extends RuntimeException {
    public AmountInvalidException(String message) {
        super(message);
    }
}
