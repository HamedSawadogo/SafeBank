package org.safebank.consumersservice.infrastructure.springframework.adapters.in.controllers.rest;

import org.safebank.consumersservice.application.usecases.consumers.CreateConsumerUseCase;
import org.safebank.consumersservice.domain.models.Consumer;
import org.safebank.consumersservice.infrastructure.commons.dtos.CreateConsumerDto;
import org.safebank.consumersservice.infrastructure.commons.mappers.ConsumerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private final CreateConsumerUseCase createConsumerUseCase;
    private final ConsumerMapper consumerMapper;

    public ConsumerController(CreateConsumerUseCase createConsumerUseCase, ConsumerMapper consumerMapper) {
        this.createConsumerUseCase = createConsumerUseCase;
        this.consumerMapper = consumerMapper;
    }

    @PostMapping("/consumers")
    public ResponseEntity<Consumer> createConsumer(@RequestBody @Validated final CreateConsumerDto request) {
        var command = consumerMapper.toCommand(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createConsumerUseCase.handle(command));
    }
}
