package org.safebank.transactionservice.infrastructure.configs;

import org.modelmapper.ModelMapper;
import org.safebank.transactionservice.application.ports.TransactionPort;
import org.safebank.transactionservice.application.usecases.deposit.DepositUseCase;
import org.safebank.transactionservice.infrastructure.configs.security.AuthenticationService;
import org.safebank.transactionservice.infrastructure.out.persistance.TransactionRepository;
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
    public DepositUseCase depositUseCase(
            TransactionRepository transactionRepository,
            AuthenticationService authenticationService) {
        return new DepositUseCase(transactionRepository, authenticationService);
    }

}
