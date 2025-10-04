package org.safebank.transactionservice.domain.models;

import org.safebank.transactionservice.domain.enums.AccountType;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import java.math.BigDecimal;
import java.time.Instant;

public class Account {
    private AccountId accountId;
    private String accountNumber;
    private BigDecimal balance;
    private Instant creationDate;
    private Instant lastUpdateDate;
    private Boolean isActive;
    private Boolean isArchived;
    private Boolean isBlocked;
    private AccountType accountType;
    private Client owner;

    public Account() {

    }

    public Account(
            AccountId accountId, String accountNumber,
            BigDecimal balance, Instant creationDate, Instant lastUpdateDate, Boolean isActive, Boolean isArchived,
            Boolean isBlocked, AccountType accountType, Client owner
    ) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.isActive = isActive;
        this.isArchived = isArchived;
        this.isBlocked = isBlocked;
        this.accountType = accountType;
        this.owner = owner;
    }
}


