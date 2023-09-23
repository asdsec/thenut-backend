package com.attech.thenutapi.account.usecase;

import com.attech.thenutapi.common.model.UseCase;
import com.attech.thenutapi.profession.model.Profession;
import com.attech.thenutapi.user.model.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AccountCreate(
        Long ownerId,
        Long professionId,
        String bio
) implements UseCase {
}
