package com.attech.thenutapi.account;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.port.AccountPort;
import com.attech.thenutapi.account.usecase.AccountCreate;
import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@DomainComponent
@RequiredArgsConstructor
public class AccountCreateUseCaseHandler implements UseCaseHandler<Account, AccountCreate> {

    private final AccountPort accountPort;

    @Override
    public Account handle(AccountCreate useCase) {
        return accountPort.create(useCase);
    }
}
