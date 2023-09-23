package com.attech.thenutapi.account;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.port.AccountPort;
import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@DomainComponent
@RequiredArgsConstructor
public class AccountRetrieveUseCaseHandler implements PrimitiveUseCaseHandler<Account, Long> {

    private final AccountPort accountPort;

    @Override
    public Account handle(Long id) {
        return accountPort.retrieve(id);
    }
}
