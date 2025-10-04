package org.safebank.transactionservice.infrastructure.out.persistance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RoleSchema {
     @Id @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private String name;
     private String description;
}
