package com.attech.thenutapi.authentication;

import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.authentication.port.AuthenticationPort;
import com.attech.thenutapi.user.port.UserPort;
import com.attech.thenutapi.user.usecase.UserCreate;
import com.attech.thenutapi.authentication.usecase.UserRegister;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UserRegisterUseCaseHandler implements UseCaseHandler<Authentication, UserRegister> {

    private final UserPort userPort;
    private final AuthenticationPort authenticationPort;

    @Override
    public Authentication handle(UserRegister useCase) {
        var user = userPort.create(buildUserCreate(useCase));
        return authenticationPort.authenticate(user);
    }

    private UserCreate buildUserCreate(UserRegister useCase) {
        return UserCreate.builder()
                .username(useCase.username())
                .email(useCase.email())
                .name(useCase.name())
                .surname(useCase.surname())
                .password(useCase.password())
                .userRole(useCase.userRole())
                .build();
    }
}
