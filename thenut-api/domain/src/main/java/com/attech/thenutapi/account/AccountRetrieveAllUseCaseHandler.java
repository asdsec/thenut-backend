package com.attech.thenutapi.account;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.port.AccountPort;
import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.EmptyUseCaseHandler;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@DomainComponent
@RequiredArgsConstructor
public class AccountRetrieveAllUseCaseHandler implements PrimitiveUseCaseHandler<List<Account>, Long> {

    private final AccountPort accountPort;

    @Override
    public List<Account> handle(Long ownerId) {
        return accountPort.retrieveAll(ownerId);
    }
}
