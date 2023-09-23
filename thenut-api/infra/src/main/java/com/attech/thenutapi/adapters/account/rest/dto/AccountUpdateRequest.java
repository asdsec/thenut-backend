package com.attech.thenutapi.adapters.account.rest.dto;

import com.attech.thenutapi.account.usecase.AccountCreate;
import com.attech.thenutapi.account.usecase.AccountUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequest {
    @NonNull
    private Long id;

    @NonNull
    private String bio;

    public AccountUpdate toUseCase() {
        return AccountUpdate.builder()
                .id(id)
                .bio(bio)
                .build();
    }
}
