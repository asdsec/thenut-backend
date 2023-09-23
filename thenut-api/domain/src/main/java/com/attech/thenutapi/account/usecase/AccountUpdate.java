package com.attech.thenutapi.account.usecase;

import com.attech.thenutapi.common.model.UseCase;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AccountUpdate(
        Long id,
        String bio
) implements UseCase {
}
