package org.safebank.consumersservice.infrastructure.springframework.out.persistance.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerSchema {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID consumerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String country;
    private List<AccountPreviewSchema> accounts;
}
    