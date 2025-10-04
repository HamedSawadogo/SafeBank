package org.safebank.consumersservice.infrastructure.springframework.out.persistance.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class AccountPreviewSchema {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountId;
    private String accountNumber;
    private BigDecimal balance;
}