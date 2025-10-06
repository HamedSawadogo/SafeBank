package org.safebank.transactionservice.domain.exceptions;

public class UnAuthorizedConsumerException extends RuntimeException {
    public UnAuthorizedConsumerException(String errorMessage) {
        super(errorMessage);
    }
}
