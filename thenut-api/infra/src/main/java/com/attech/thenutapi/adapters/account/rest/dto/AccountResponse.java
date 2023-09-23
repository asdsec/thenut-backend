package com.attech.thenutapi.adapters.account.rest.dto;

import com.attech.thenutapi.account.model.Account;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long id;
    private Long ownerId;
    private Long professionId;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AccountResponse from(Account account) {
        return AccountResponse.builder()
                .id(account.id())
                .ownerId(account.ownerId())
                .professionId(account.professionId())
                .bio(account.bio())
                .createdAt(account.createdAt())
                .updatedAt(account.updatedAt())
                .build();
    }
}
