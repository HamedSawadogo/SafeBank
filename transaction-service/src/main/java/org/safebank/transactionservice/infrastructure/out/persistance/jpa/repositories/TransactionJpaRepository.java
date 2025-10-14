package org.safebank.transactionservice.infrastructure.out.persistance.jpa.repositories;

import org.safebank.transactionservice.infrastructure.out.persistance.jpa.schemas.AccountSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<AccountSchema, UUID> {
    @Modifying
    @Query("UPDATE AccountSchema a SET a.balance=:amount WHERE a.accountId=:accountId")
    void updateAccountAmount(String accountId, BigDecimal amount);

}
