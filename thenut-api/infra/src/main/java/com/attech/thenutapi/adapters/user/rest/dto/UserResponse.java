package com.attech.thenutapi.adapters.user.rest.dto;

import com.attech.thenutapi.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String userRole;
    private String userStatus;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.id())
                .username(user.username())
                .email(user.email())
                .name(user.name())
                .surname(user.surname())
                .userRole(user.userRole().name())
                .userStatus(user.userStatus().name())
                .build();
    }
}
