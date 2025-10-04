package org.safebank.consumersservice.application.usecases.commands;

public record CreateConsumerCommand (
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String country
) {

}
