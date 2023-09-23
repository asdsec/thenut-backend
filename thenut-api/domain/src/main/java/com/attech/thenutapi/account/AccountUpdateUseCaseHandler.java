package com.attech.thenutapi.account;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.port.AccountPort;
import com.attech.thenutapi.account.usecase.AccountUpdate;
import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.model.UseCase;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class AccountUpdateUseCaseHandler implements UseCaseHandler<Account, AccountUpdate> {

    private final AccountPort accountPort;

    @Override
    public Account handle(AccountUpdate useCase) {
        return accountPort.update(useCase);
    }
}
