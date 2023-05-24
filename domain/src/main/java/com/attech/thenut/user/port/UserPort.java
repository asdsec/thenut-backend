package com.attech.thenut.user.port;

import com.attech.thenut.user.model.User;
import com.attech.thenut.user.usecase.UserCreate;

public interface UserPort {
    User create(UserCreate useCase);

    User retrieve(Long id);
}