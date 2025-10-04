package org.safebank.consumersservice.infrastructure.springframework.in.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class CreateConsumerDto {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Email
    String email;
    @NotBlank
    String phoneNumber;
    @NotBlank
    String country;
}