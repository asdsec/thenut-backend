package com.attech.thenutapi.adapters.account.jpa.entity;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.common.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "accounts",
        indexes = {
                @Index(name = "idx_owner", columnList = "ownerId", unique = true),
                @Index(name = "idx_profession", columnList = "professionId", unique = true)
        }
)
public class AccountEntity extends AbstractEntity {

    @Column(nullable = false, unique = true, updatable = false)
    private Long ownerId;

    @Column(nullable = false, unique = true, updatable = false)
    private Long professionId;

    @Column(nullable = false)
    private String bio;

    public Account toModel() {
        return Account.builder()
                .id(super.getId())
                .ownerId(ownerId)
                .professionId(professionId)
                .bio(bio)
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
                .build();
    }
}
