package org.safebank.consumersservice.infrastructure.springframework.configs;

import org.modelmapper.ModelMapper;
import org.safebank.consumersservice.application.usecases.consumers.CreateConsumerUseCase;
import org.safebank.consumersservice.infrastructure.springframework.out.persistance.repositories.adapters.ConsumerJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig
{
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

    @Bean
    public CreateConsumerUseCase createConsumerUseCase (ConsumerJpaRepositoryAdapter consumerJpaRepositoryAdapter) {
        return new CreateConsumerUseCase(consumerJpaRepositoryAdapter);
    }
}
