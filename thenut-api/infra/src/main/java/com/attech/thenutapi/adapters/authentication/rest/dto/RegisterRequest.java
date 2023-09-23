package com.attech.thenutapi.adapters.authentication.rest.dto;

import com.attech.thenutapi.authentication.usecase.UserRegister;
import com.attech.thenutapi.user.model.UserRole;
import com.attech.thenutapi.user.model.UserStatus;
import com.attech.thenutapi.user.usecase.UserCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String name;
    private String surname;
    private String password;
    private UserRole userRole;

    public UserRegister toUseCase() {
        return UserRegister.builder()
                .username(username)
                .email(email)
                .name(name)
                .surname(surname)
                .password(password)
                .userRole(userRole)
                .build();
    }
}
