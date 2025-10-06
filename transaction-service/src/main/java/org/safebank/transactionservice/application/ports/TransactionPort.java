package org.safebank.transactionservice.application.ports;


import org.safebank.transactionservice.domain.models.Account;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import java.util.Optional;

public interface TransactionPort
{
    Optional<Account> getAccountById(AccountId accountId);
    void updateAmount(Account account);
}
