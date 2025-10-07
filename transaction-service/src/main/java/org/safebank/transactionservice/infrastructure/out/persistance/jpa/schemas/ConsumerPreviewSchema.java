package org.safebank.transactionservice.infrastructure.out.persistance.jpa.schemas;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class ConsumerPreviewSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    private AccountSchema account;
}
