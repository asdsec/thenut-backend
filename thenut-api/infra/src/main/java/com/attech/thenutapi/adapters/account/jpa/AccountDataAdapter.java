package com.attech.thenutapi.adapters.account.jpa;

import com.attech.thenutapi.account.model.Account;
import com.attech.thenutapi.account.port.AccountPort;
import com.attech.thenutapi.account.usecase.AccountCreate;
import com.attech.thenutapi.account.usecase.AccountUpdate;
import com.attech.thenutapi.adapters.account.jpa.entity.AccountEntity;
import com.attech.thenutapi.adapters.account.jpa.repository.AccountJpaRepository;
import com.attech.thenutapi.common.exception.ThenutApiDataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountDataAdapter implements AccountPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account retrieve(Long id) {
        return accountJpaRepository.findById(id)
                .map(AccountEntity::toModel)
                .orElseThrow(() -> new ThenutApiDataNotFoundException("thenutapi.meetup.notFound"));
    }

    @Override
    public List<Account> retrieveAll(Long userId) {
        return accountJpaRepository.getAllByOwnerId(userId)
                .stream()
                .map(AccountEntity::toModel)
                .toList();
    }

    @Override
    public Account create(AccountCreate accountCreate) {
        var accountEntity = new AccountEntity();
        accountEntity.setOwnerId(accountCreate.ownerId());
        accountEntity.setProfessionId(accountCreate.professionId());
        accountEntity.setBio(accountCreate.bio());
        return accountJpaRepository.save(accountEntity).toModel();
    }

    @Override
    public Account update(AccountUpdate accountUpdate) {
        var accountEntity = new AccountEntity();
        accountEntity.setBio(accountUpdate.bio());
        return accountJpaRepository.save(accountEntity).toModel();
    }

    @Override
    public void delete(Long id) {

    }

}
