package org.safebank.consumersservice.infrastructure.springframework.in.mappers;

import org.safebank.consumersservice.application.usecases.commands.CreateConsumerCommand;
import org.safebank.consumersservice.infrastructure.springframework.in.dtos.CreateConsumerDto;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMapper {
    public CreateConsumerCommand toCommand(CreateConsumerDto dto) {
        if (dto == null) {
            return null;
        }
        return new CreateConsumerCommand(
           dto.firstName(),
           dto.lastName(),
           dto.email(),
           dto.phoneNumber(),
           dto.country()
        );
    }
}
