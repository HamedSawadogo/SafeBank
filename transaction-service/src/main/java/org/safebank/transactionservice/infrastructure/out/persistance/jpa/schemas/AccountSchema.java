package org.safebank.transactionservice.infrastructure.out.persistance.jpa.schemas;

import jakarta.persistence.*;
import lombok.*;
import org.safebank.transactionservice.domain.enums.AccountType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class AccountSchema
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountId;
    private String accountNumber;
    private BigDecimal balance;
    private Instant creationDate;
    private Instant lastUpdateDate;
    private Boolean isActive;
    private Boolean isArchived;
    private Boolean isBlocked;
    private AccountType accountType;
    @OneToOne(fetch = FetchType.LAZY)
    private ConsumerPreviewSchema owner;
}
