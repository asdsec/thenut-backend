package com.attech.thenutapi.adapters.profession.rest.dto;

import com.attech.thenutapi.profession.usecase.ProfessionApplicationCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionApplicationCreateRequest {
    @NonNull
    private String profession;

    @NonNull
    private Long userId;

    public ProfessionApplicationCreate toUseCase() {
        return ProfessionApplicationCreate.builder()
                .profession(profession)
                .userId(userId)
                .build();
    }
}
