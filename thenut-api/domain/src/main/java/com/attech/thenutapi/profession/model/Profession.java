package com.attech.thenutapi.profession.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Profession(
        Long id,
        String name,
        LocalDateTime createAt,
        LocalDateTime updatedAt
) {
}
