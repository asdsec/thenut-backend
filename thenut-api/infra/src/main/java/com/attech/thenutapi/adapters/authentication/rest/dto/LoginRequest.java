package com.attech.thenutapi.adapters.authentication.rest.dto;

import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.authentication.usecase.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

    public UserLogin toUseCase() {
        return UserLogin.builder()
                .username(username)
                .password(password)
                .build();
    }
}
