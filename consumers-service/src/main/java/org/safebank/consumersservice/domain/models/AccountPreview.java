package org.safebank.consumersservice.domain.models;

import java.math.BigDecimal;

public class AccountPreview {
    private String accountId;
    private String accountNumber;
    private BigDecimal balance;

    public AccountPreview() {

    }

    public AccountPreview(String accountId, String accountNumber, BigDecimal balance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


}
