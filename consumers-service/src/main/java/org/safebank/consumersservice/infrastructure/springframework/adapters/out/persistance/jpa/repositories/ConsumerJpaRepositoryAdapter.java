package org.safebank.consumersservice.infrastructure.springframework.adapters.out.persistance.jpa.repositories;

import org.modelmapper.ModelMapper;
import org.safebank.consumersservice.application.ports.ConsumerRepositoryPort;
import org.safebank.consumersservice.domain.models.Consumer;
import org.safebank.consumersservice.infrastructure.commons.mappers.ConsumerMapper;
import org.safebank.consumersservice.infrastructure.springframework.adapters.out.persistance.jpa.repositories.jpa.ConsumerJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ConsumerJpaRepositoryAdapter implements ConsumerRepositoryPort  {
    private final ModelMapper modelMapper;
    private final ConsumerMapper consumerMapper;
    private final ConsumerJpaRepository consumerJpaRepository;

    public ConsumerJpaRepositoryAdapter(ModelMapper modelMapper, ConsumerMapper consumerMapper, ConsumerJpaRepository consumerJpaRepository) {
        this.modelMapper = modelMapper;
        this.consumerMapper = consumerMapper;
        this.consumerJpaRepository = consumerJpaRepository;
    }

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
        var schema = consumerMapper.toSchema(consumer);
        return modelMapper.map(consumerJpaRepository.save(schema), Consumer.class);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Consumer update(Consumer consumer) {
        return null;
    }
}
