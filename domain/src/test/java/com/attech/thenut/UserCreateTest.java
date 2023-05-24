package com.attech.thenut;

import com.attech.thenut.adapters.UserFakeDataAdapter;
import com.attech.thenut.user.UserCreateUseCaseHandler;
import com.attech.thenut.user.model.User;
import com.attech.thenut.user.usecase.UserCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreateTest {

    UserCreateUseCaseHandler userCreateUseCaseHandler;

    @BeforeEach
    void setUp() {
        userCreateUseCaseHandler = new UserCreateUseCaseHandler(new UserFakeDataAdapter());
    }

    @Test
    void should_create_user() {
        // given
        UserCreate userCreate = UserCreate.builder()
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

        // when
        var user = userCreateUseCaseHandler.handle(userCreate);

        // then
        assertThat(user).isNotNull()
                .returns(1L, User::getId)
                .returns("test username", User::getUsername)
                .returns("test name", User::getName)
                .returns("test surname", User::getSurname)
                .returns("test email", User::getEmail)
                .returns("test phone number", User::getPhoneNumber)
                .returns("test image url", User::getImageUrl)
                .returns('m', User::getGender)
                .returns(false, User::getDisabled)
                .returns(LocalDateTime.of(2001, 1, 1, 20, 0, 0), User::getBirthDate)
                .returns(LocalDateTime.of(2021, 1, 1, 20, 0, 0), User::getPasswordChangedAt)
                .returns(LocalDateTime.of(2021, 1, 1, 20, 0, 0), User::getCreatedAt);

    }

}
