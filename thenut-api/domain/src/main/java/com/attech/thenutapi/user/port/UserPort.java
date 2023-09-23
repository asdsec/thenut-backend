package com.attech.thenutapi.user.port;

import com.attech.thenutapi.user.model.User;
import com.attech.thenutapi.user.usecase.UserCreate;

public interface UserPort {
    User create(UserCreate userCreate);
    User retrieve(Long id);
    User retrieve(String username);
}
