package com.attech.thenutapi.adapters.authentication.rest;

import com.attech.thenutapi.adapters.authentication.rest.dto.AuthenticationResponse;
import com.attech.thenutapi.adapters.authentication.rest.dto.LoginRequest;
import com.attech.thenutapi.adapters.authentication.rest.dto.RegisterRequest;
import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.authentication.usecase.UserLogin;
import com.attech.thenutapi.authentication.usecase.UserRegister;
import com.attech.thenutapi.common.rest.BaseController;
import com.attech.thenutapi.common.rest.Response;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import com.attech.thenutapi.user.model.User;
import com.attech.thenutapi.user.usecase.UserCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// TODO: Add validation

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController extends BaseController {
    private final UseCaseHandler<Authentication, UserRegister> userRegisterUseCaseHandler;
    private final UseCaseHandler<Authentication, UserLogin> userLoginUseCaseHandler;

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        var auth = userRegisterUseCaseHandler.handle(request.toUseCase());
        return respond(AuthenticationResponse.from(auth));
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        var auth = userLoginUseCaseHandler.handle(request.toUseCase());
        return respond(AuthenticationResponse.from(auth));
    }
}
