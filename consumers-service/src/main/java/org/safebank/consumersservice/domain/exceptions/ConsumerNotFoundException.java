package org.safebank.consumersservice.domain.exceptions;


public class ConsumerNotFoundException extends RuntimeException {
    public ConsumerNotFoundException(String message) {
        super(String.format(message));
    }
}
