package com.attech.thenutapi.adapters.account.rest;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.usecase.AccountCreate;
import com.attech.thenutapi.account.usecase.AccountUpdate;
import com.attech.thenutapi.adapters.account.rest.dto.AccountCreateRequest;
import com.attech.thenutapi.adapters.account.rest.dto.AccountResponse;
import com.attech.thenutapi.adapters.account.rest.dto.AccountUpdateRequest;
import com.attech.thenutapi.common.rest.BaseController;
import com.attech.thenutapi.common.rest.DataResponse;
import com.attech.thenutapi.common.rest.Response;
import com.attech.thenutapi.common.usecase.EmptyUseCaseHandler;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Add validation

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController extends BaseController {
    private final UseCaseHandler<Account, AccountCreate> accountAccountCreateUseCaseHandler;
    private final PrimitiveUseCaseHandler<List<Account>, Long> accountRetrieveAllUseCaseHandler;
    private final PrimitiveUseCaseHandler<Account, Long> accountRetrieveUseCaseHandler;
    private final UseCaseHandler<Account, AccountUpdate> accountUpdateUseCaseHandler;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AccountResponse> getAccount(@PathVariable Long id) {
        var account = accountRetrieveUseCaseHandler.handle(id);
        return respond(AccountResponse.from(account));
    }

    @GetMapping(path = "/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public DataResponse<AccountResponse> getAllAccounts(@PathVariable Long ownerId) {
        var accounts = accountRetrieveAllUseCaseHandler.handle(ownerId);
        return respond(accounts.stream().map(AccountResponse::from).toList()).getData();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<AccountResponse> createAccount(@RequestBody AccountCreateRequest request) {
        var account = accountAccountCreateUseCaseHandler.handle(request.toUseCase());
        return respond(AccountResponse.from(account));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<AccountResponse> updateAccount(@RequestBody AccountUpdateRequest request) {
        var account = accountUpdateUseCaseHandler.handle(request.toUseCase());
        return respond(AccountResponse.from(account));
    }
}
