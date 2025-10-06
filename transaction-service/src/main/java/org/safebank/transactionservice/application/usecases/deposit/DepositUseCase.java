package org.safebank.transactionservice.application.usecases.deposit;


import org.safebank.transactionservice.application.ports.AuthenticationPort;
import org.safebank.transactionservice.application.ports.TransactionPort;
import org.safebank.transactionservice.domain.exceptions.AccountNotFoundException;
import org.safebank.transactionservice.domain.exceptions.AmountInvalidException;
import org.safebank.transactionservice.domain.exceptions.UnAuthorizedConsumerException;
import org.safebank.transactionservice.domain.valueobjects.AccountId;

import java.math.BigDecimal;

public class DepositUseCase {
    private final TransactionPort transactionPort;
    private final AuthenticationPort authenticationPort;

    public DepositUseCase(TransactionPort transactionPort, AuthenticationPort authenticationPort) {
        this.transactionPort = transactionPort;
        this.authenticationPort = authenticationPort;
    }

    public synchronized BigDecimal handle(final AccountId accountId, final BigDecimal amount) {
       var authenticatedUser =  authenticationPort.getAuthenticatedConsumer();
       if (authenticatedUser == null || !isOwnerAuthenticateConsumer(accountId)) {
           throw new UnAuthorizedConsumerException("this consumer is unAuthorized to process this operation");
       }
       var accountFound = transactionPort.getAccountById(accountId);
       if (accountFound.isEmpty()) {
           throw new AccountNotFoundException("account with id " + accountId + " not found");
       }
       var account = accountFound.get();
       if (account.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
           throw new  AmountInvalidException("invalid amount");
       }
       var accountAmount = account.getBalance();
       account.setBalance(accountAmount.add(amount));
       transactionPort.updateAmount(account);
       return account.getBalance();
    }

    private boolean isOwnerAuthenticateConsumer(final AccountId accountId) {
        return  accountId != null && accountId.equals(authenticationPort.getAuthenticatedConsumer().getAccount().getAccountId());
    }
}
