package com.attech.thenutapi.adapters.user.rest;

// TODO: Add validation

import com.attech.thenutapi.adapters.user.rest.dto.UserResponse;
import com.attech.thenutapi.common.rest.BaseController;
import com.attech.thenutapi.common.rest.Response;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import com.attech.thenutapi.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {
    private final PrimitiveUseCaseHandler<User, Long> userRetrieveUseCaseHandler;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<UserResponse> getUser(@PathVariable Long id) {
        var user = userRetrieveUseCaseHandler.handle(id);
        return respond(UserResponse.from(user));
    }
}
