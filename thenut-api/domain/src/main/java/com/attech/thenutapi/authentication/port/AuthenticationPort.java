package com.attech.thenutapi.authentication.port;

import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.user.model.User;

public interface AuthenticationPort {
    Authentication authenticate(User user);
}
