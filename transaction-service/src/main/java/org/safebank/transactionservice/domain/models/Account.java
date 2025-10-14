package org.safebank.transactionservice.domain.models;

import org.safebank.transactionservice.domain.enums.AccountType;
import org.safebank.transactionservice.domain.exceptions.InvalidAmountException;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import org.safebank.transactionservice.domain.valueobjects.Amount;
import java.math.BigDecimal;
import java.time.Instant;


public class Account {
    private AccountId accountId;
    private String accountNumber;
    private Amount amount;
    private Instant creationDate;
    private Instant lastUpdateDate;
    private Boolean isActive;
    private Boolean isArchived;
    private Boolean isBlocked;
    private AccountType accountType;
    private ConsumerPreview owner;

    public Account() {
        this.amount = new Amount(BigDecimal.ZERO);
    }

    public Account(
            AccountId accountId, String accountNumber,
            BigDecimal balance, Instant creationDate, Instant lastUpdateDate, Boolean isActive, Boolean isArchived,
            Boolean isBlocked, AccountType accountType
    ) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.amount = new Amount(balance);
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.isActive = isActive;
        this.isArchived = isArchived;
        this.isBlocked = isBlocked;
        this.accountType = accountType;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public void setAmount(Amount amount) {
        if (amount == null)  {
            throw new InvalidAmountException("");
        }
        this.amount = amount;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public ConsumerPreview getOwner() {
        return owner;
    }

    public void setOwner(ConsumerPreview owner) {
        this.owner = owner;
    }
}


