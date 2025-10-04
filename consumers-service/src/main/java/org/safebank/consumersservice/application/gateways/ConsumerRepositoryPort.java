package org.safebank.consumersservice.application.gateways;

import org.safebank.consumersservice.domain.models.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConsumerRepositoryPort {
    Optional<Consumer> findById(String id);
    Boolean existByEmail(String email);
    List<Consumer> findAll();
    Consumer save(Consumer consumer);
    void delete(String id);
    Consumer update(Consumer consumer);
}
