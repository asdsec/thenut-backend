package com.attech.thenutapi.authentication.usecase;

import com.attech.thenutapi.common.model.UseCase;
import lombok.Builder;

@Builder
public record UserLogin(
        String username,
        String password
) implements UseCase {
}
