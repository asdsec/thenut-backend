package com.attech.thenutapi.adapters.authentication.rest.dto;

import com.attech.thenutapi.authentication.model.Authentication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String username;
    private String email;
    private String token;
    private Boolean enabled;
    private Integer expiresIn;

    public static AuthenticationResponse from(Authentication authentication) {
        return AuthenticationResponse.builder()
                .username(authentication.username())
                .email(authentication.email())
                .token(authentication.token().token())
                .enabled(authentication.enabled())
                .expiresIn(authentication.token().expiresIn())
                .build();
    }
}
