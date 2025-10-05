package org.safebank.consumersservice.application.usecases.consumers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.safebank.consumersservice.application.gateways.ConsumerRepositoryPort;
import org.safebank.consumersservice.application.usecases.commands.CreateConsumerCommand;
import org.safebank.consumersservice.domain.exceptions.ConsumerNotFoundException;
import org.safebank.consumersservice.domain.models.Consumer;

public class CreateConsumerUseCase {
    private static final Log log = LogFactory.getLog(CreateConsumerUseCase.class);
    private final ConsumerRepositoryPort consumerPort;


    public CreateConsumerUseCase(ConsumerRepositoryPort consumerPort) {
        this.consumerPort = consumerPort;
    }

    public Consumer handle(CreateConsumerCommand command) {
        log.info("received command: " + command);
        System.err.println("Email ??" + consumerPort.existByEmail(command.email()));
        if (consumerPort.existByEmail(command.email())) {
           log.info("consumer with email " + command.email() + " already exists");
           throw new ConsumerNotFoundException(String.format("consumer with email %s already exists", command.email()));
        }
        var consumer = new Consumer();
        consumer.setEmail(command.email());
        consumer.setCountry(command.country());
        consumer.setFirstName(command.firstName());
        consumer.setLastName(command.lastName());
        consumer.setPhoneNumber(command.phoneNumber());
        return consumerPort.save(consumer);
    }
}
