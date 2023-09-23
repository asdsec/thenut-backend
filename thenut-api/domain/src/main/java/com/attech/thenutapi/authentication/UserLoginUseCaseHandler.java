package com.attech.thenutapi.authentication;

import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.exception.ThenutApiAuthenticationException;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.authentication.port.AuthenticationPort;
import com.attech.thenutapi.user.port.UserPort;
import com.attech.thenutapi.authentication.usecase.UserLogin;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UserLoginUseCaseHandler implements UseCaseHandler<Authentication, UserLogin> {

    private final UserPort userPort;
    private final AuthenticationPort authenticationPort;

    @Override
    public Authentication handle(UserLogin useCase) throws ThenutApiAuthenticationException {
        var user = userPort.retrieve(useCase.username());
        if (!user.password().equals(useCase.password())) {
            throw new ThenutApiAuthenticationException("thenutapi.auth.invalidCredentials");
        }
        return authenticationPort.authenticate(user);
    }
}
