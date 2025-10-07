package org.safebank.consumersservice.infrastructure.commons.mappers;

import org.safebank.consumersservice.application.usecases.commands.CreateConsumerCommand;
import org.safebank.consumersservice.domain.models.Consumer;
import org.safebank.consumersservice.infrastructure.commons.dtos.CreateConsumerDto;
import org.safebank.consumersservice.infrastructure.springframework.adapters.out.persistance.jpa.entities.ConsumerSchema;
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

    public ConsumerSchema toSchema(Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        var consumerSchema = new ConsumerSchema();
        consumerSchema.setFirstName(consumer.getFirstName());
        consumerSchema.setLastName(consumer.getLastName());
        consumerSchema.setEmail(consumer.getEmail());
        consumerSchema.setPhoneNumber(consumer.getPhoneNumber());
        consumerSchema.setCountry(consumer.getCountry());
        return consumerSchema;
    }
}
