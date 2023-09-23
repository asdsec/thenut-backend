package com.attech.thenutapi.account.port;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.usecase.AccountCreate;
import com.attech.thenutapi.account.usecase.AccountUpdate;
import com.attech.thenutapi.common.exception.ThenutApiDataNotFoundException;

import java.util.List;

public interface AccountPort {
    Account retrieve(Long id);
    List<Account> retrieveAll(Long userId);
    Account create(AccountCreate accountCreate);
    Account update(AccountUpdate accountUpdate);
    void delete(Long id);
}
