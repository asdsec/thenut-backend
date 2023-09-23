package com.attech.thenutapi.profession.usecase;

import com.attech.thenutapi.common.model.UseCase;
import lombok.Builder;

@Builder
public record ProfessionApplicationCreate(
        String profession,
        Long userId
) implements UseCase {
}
