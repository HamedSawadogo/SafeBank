package org.safebank.transactionservice.application.usecases.deposit;


import org.safebank.transactionservice.application.ports.AuthenticationPort;
import org.safebank.transactionservice.application.ports.TransactionPort;
import org.safebank.transactionservice.domain.exceptions.AccountNotFoundException;
import org.safebank.transactionservice.domain.exceptions.UnAuthorizedConsumerException;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import org.safebank.transactionservice.domain.valueobjects.Amount;

import java.math.BigDecimal;

public class DepositUseCase {
    private final TransactionPort transactionPort;
    private final AuthenticationPort authenticationPort;

    public DepositUseCase(TransactionPort transactionPort, AuthenticationPort authenticationPort) {
        this.transactionPort = transactionPort;
        this.authenticationPort = authenticationPort;
    }

    public Amount handle(final AccountId accountId, final BigDecimal amount) {
       var authenticatedUser =  authenticationPort.getAuthenticatedConsumer();
       if (authenticatedUser == null || !isOwnerAuthenticateConsumer(accountId)) {
           throw new UnAuthorizedConsumerException("this consumer is unAuthorized to process this operation");
       }
       var accountFound = transactionPort.getAccountById(accountId);
       if (accountFound.isEmpty()) {
           throw new AccountNotFoundException("account with id " + accountId + " not found");
       }
       var account = accountFound.get();
       var accountAmount = account.getAmount().amount();
       var newAmount =  new Amount(accountAmount.add(amount));
       account.setAmount(newAmount);
       transactionPort.updateAmount(accountId, newAmount);
       return newAmount;
    }

    private boolean isOwnerAuthenticateConsumer(final AccountId accountId) {
        return  accountId != null && accountId.equals(authenticationPort.getAuthenticatedConsumer().getAccount().getAccountId());
    }
}
