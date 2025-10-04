package org.safebank.consumersservice.infrastructure.springframework.out.persistance.repositories.adapters;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.safebank.consumersservice.application.gateways.ConsumerRepositoryPort;
import org.safebank.consumersservice.domain.models.Consumer;
import org.safebank.consumersservice.infrastructure.springframework.out.persistance.repositories.jpa.ConsumerJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ConsumerJpaRepositoryAdapter implements ConsumerRepositoryPort  {

    private final ModelMapper modelMapper;
    private final ConsumerJpaRepository consumerJpaRepository;

    @Override
    public Optional<Consumer> findById(String id) {
        return Optional.of(modelMapper.map(consumerJpaRepository.findById(UUID.fromString(id)), Consumer.class));
    }

    @Override
    public Boolean existByEmail(String email) {
        return consumerJpaRepository.existsByEmail(email);
    }

    @Override
    public List<Consumer> findAll() {
        return List.of();
    }

    @Override
    public Consumer save(Consumer consumer) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Consumer update(Consumer consumer) {
        return null;
    }
}
