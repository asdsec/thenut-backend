package com.attech.thenut.user.usecase;

import com.attech.thenut.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserCreate implements UseCase {

    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String imageUrl;
    private Character gender;
    private Boolean disabled;
    private LocalDateTime birthDate;
    private LocalDateTime passwordChangedAt;
    private LocalDateTime createdAt;

}
