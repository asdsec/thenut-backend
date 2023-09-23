package com.attech.thenutapi.adapters.account.jpa.repository;

import com.attech.thenutapi.adapters.account.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> getAllByOwnerId(Long ownerId);
}
