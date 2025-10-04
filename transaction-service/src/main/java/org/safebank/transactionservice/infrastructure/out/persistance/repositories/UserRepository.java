package org.safebank.transactionservice.infrastructure.out.persistance.repositories;

import org.bank.safebank.infrastructure.out.persistance.entities.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserSchema, UUID> {
   Optional<UserSchema> findByEmail(String email);
}
