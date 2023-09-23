package com.attech.thenutapi.account.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Account(
        Long id,
        Long ownerId,
        Long professionId,
        String bio,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
