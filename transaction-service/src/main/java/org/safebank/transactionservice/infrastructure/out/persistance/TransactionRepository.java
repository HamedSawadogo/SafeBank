package org.safebank.transactionservice.infrastructure.out.persistance;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.safebank.transactionservice.application.ports.TransactionPort;
import org.safebank.transactionservice.domain.models.Account;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import org.safebank.transactionservice.domain.valueobjects.Amount;
import org.safebank.transactionservice.infrastructure.out.persistance.jpa.repositories.TransactionJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TransactionRepository implements TransactionPort {
    private final TransactionJpaRepository transactionJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Account> getAccountById(AccountId accountId) {
        var account = transactionJpaRepository.findById(UUID.fromString(accountId.id()));
        return Optional.of(modelMapper.map(account, Account.class));
    }

    @Override
    public void updateAmount(AccountId accountId, Amount amount) {
        transactionJpaRepository.updateAccountAmount(accountId.id(), amount.amount());
    }


}
