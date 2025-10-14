package org.safebank.transactionservice.domain.valueobjects;

import org.safebank.transactionservice.domain.exceptions.InvalidAmountException;
import java.math.BigDecimal;

public record Amount (BigDecimal amount) {
    public Amount {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("amount must be greater than zero");
        }
    }

}
