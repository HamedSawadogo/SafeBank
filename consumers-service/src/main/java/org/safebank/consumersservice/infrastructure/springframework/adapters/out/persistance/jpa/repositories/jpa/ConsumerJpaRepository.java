package org.safebank.consumersservice.infrastructure.springframework.adapters.out.persistance.jpa.repositories.jpa;

import org.safebank.consumersservice.infrastructure.springframework.adapters.out.persistance.jpa.entities.ConsumerSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface ConsumerJpaRepository extends JpaRepository<ConsumerSchema, UUID> {
    Boolean existsByEmail(String email);
}
