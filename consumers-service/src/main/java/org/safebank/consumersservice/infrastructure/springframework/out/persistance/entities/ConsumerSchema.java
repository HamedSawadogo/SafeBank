package org.safebank.consumersservice.infrastructure.springframework.out.persistance.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "consumers")
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
    @OneToMany(fetch = FetchType.LAZY)
    private List<AccountPreviewSchema> accounts;
}
    