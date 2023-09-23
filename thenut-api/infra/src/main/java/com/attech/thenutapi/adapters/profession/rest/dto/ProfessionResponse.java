package com.attech.thenutapi.adapters.profession.rest.dto;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.adapters.account.rest.dto.AccountResponse;
import com.attech.thenutapi.profession.model.Profession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionResponse {
    private Long id;
    private String name;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public static List<ProfessionResponse> from(List<Profession> professions) {
        return professions.stream().map(profession -> ProfessionResponse.builder()
                .id(profession.id())
                .name(profession.name())
                .createAt(profession.createAt())
                .updatedAt(profession.updatedAt())
                .build()
        ).toList();
    }
}
