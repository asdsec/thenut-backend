package com.attech.thenutapi.user.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record User(
        Long id,
        String username,
        String email,
        String name,
        String surname,
        String password,
        UserRole userRole,
        UserStatus userStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Boolean enabled() {
        return !userStatus.equals(UserStatus.DISABLED);
    }
}
