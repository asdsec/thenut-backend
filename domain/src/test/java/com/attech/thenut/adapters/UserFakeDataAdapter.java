package com.attech.thenut.adapters;

import com.attech.thenut.user.model.User;
import com.attech.thenut.user.port.UserPort;
import com.attech.thenut.user.usecase.UserCreate;

import java.time.LocalDateTime;

public class UserFakeDataAdapter implements UserPort {

    @Override
    public User create(UserCreate userCreate) {
        return User.builder()
                .id(1L)
                .username(userCreate.getUsername())
                .name(userCreate.getName())
                .surname(userCreate.getSurname())
                .email(userCreate.getEmail())
                .phoneNumber(userCreate.getPhoneNumber())
                .imageUrl(userCreate.getImageUrl())
                .gender(userCreate.getGender())
                .disabled(userCreate.getDisabled())
                .birthDate(userCreate.getBirthDate())
                .passwordChangedAt(userCreate.getPasswordChangedAt())
                .createdAt(userCreate.getCreatedAt())
                .build();
    }

    @Override
    public User retrieve(Long id) {
        return User.builder()
                .id(id)
                .username("test username")
                .name("test name")
                .surname("test surname")
                .email("test email")
                .phoneNumber("test phone number")
                .imageUrl("test image url")
                .gender('m')
                .disabled(false)
                .birthDate(LocalDateTime.of(2001, 1, 1, 20, 0, 0))
                .passwordChangedAt(LocalDateTime.of(2021, 1, 1, 20, 0, 0))
                .createdAt(LocalDateTime.of(2021, 1, 1, 20, 0, 0))
                .build();
    }
}
