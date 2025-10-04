package org.safebank.consumersservice.infrastructure.springframework.in;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.safebank.consumersservice.application.usecases.commands.CreateConsumerCommand;
import org.safebank.consumersservice.application.usecases.consumers.CreateConsumerUseCase;
import org.safebank.consumersservice.domain.models.Consumer;
import org.safebank.consumersservice.infrastructure.springframework.in.dtos.CreateConsumerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final CreateConsumerUseCase createConsumerUseCase;
    private final ModelMapper modelMapper;

    @PostMapping("/consumers")
    public ResponseEntity<Consumer> createConsumer(@RequestBody @Validated final CreateConsumerDto request) {
        var dto = modelMapper.map(request, CreateConsumerCommand.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createConsumerUseCase.handle(dto));
    }
}
