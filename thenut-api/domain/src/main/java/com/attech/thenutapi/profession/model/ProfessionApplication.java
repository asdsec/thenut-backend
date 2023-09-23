package com.attech.thenutapi.profession.model;

import com.attech.thenutapi.user.model.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProfessionApplication(
        Long id,
        String profession,
        Long userId,
        ApplicationStatus applicationStatus,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
