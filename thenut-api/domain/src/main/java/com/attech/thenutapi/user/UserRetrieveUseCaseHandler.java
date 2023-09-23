package com.attech.thenutapi.user;

import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import com.attech.thenutapi.user.model.User;
import com.attech.thenutapi.user.port.UserPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UserRetrieveUseCaseHandler implements PrimitiveUseCaseHandler<User, Long> {
    private final UserPort userPort;

    @Override
    public User handle(Long id) {
        return userPort.retrieve(id);
    }
}
