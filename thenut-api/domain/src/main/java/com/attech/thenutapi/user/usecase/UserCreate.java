package com.attech.thenutapi.user.usecase;

import com.attech.thenutapi.common.model.UseCase;
import com.attech.thenutapi.user.model.UserRole;
import lombok.Builder;

@Builder
public record UserCreate(
        String username,
        String email,
        String name,
        String surname,
        String password,
        UserRole userRole
) implements UseCase {
}
