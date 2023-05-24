package com.attech.thenut.user;

import com.attech.thenut.common.DomainComponent;
import com.attech.thenut.common.usecase.UseCaseHandler;
import com.attech.thenut.user.model.User;
import com.attech.thenut.user.port.UserPort;
import com.attech.thenut.user.usecase.UserCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class UserCreateUseCaseHandler implements UseCaseHandler<User, UserCreate> {

    private final UserPort userPort;

    @Override
    public User handle(UserCreate useCase) {
        return userPort.create(useCase);
    }
}
