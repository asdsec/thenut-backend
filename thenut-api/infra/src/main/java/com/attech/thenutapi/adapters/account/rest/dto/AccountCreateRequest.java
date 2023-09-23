package com.attech.thenutapi.adapters.account.rest.dto;

import com.attech.thenutapi.account.usecase.AccountCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateRequest {
    @NonNull
    private Long ownerId;

    @NonNull
    private Long professionId;

    @NonNull
    private String bio;

    public AccountCreate toUseCase() {
        return AccountCreate.builder()
                .ownerId(ownerId)
                .professionId(professionId)
                .bio(bio)
                .build();
    }
}
