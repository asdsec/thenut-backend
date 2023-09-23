package com.attech.thenutapi.adapters.user.jpa;

import com.attech.thenutapi.adapters.user.jpa.entity.UserEntity;
import com.attech.thenutapi.adapters.user.jpa.repository.UserJpaRepository;
import com.attech.thenutapi.common.exception.ThenutApiDataNotFoundException;
import com.attech.thenutapi.user.model.User;
import com.attech.thenutapi.user.model.UserStatus;
import com.attech.thenutapi.user.port.UserPort;
import com.attech.thenutapi.user.usecase.UserCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataAdapter implements UserPort {

    private UserJpaRepository userJpaRepository;

    @Override
    public User create(UserCreate userCreate) {
        var userEntity = new UserEntity();
        userEntity.setUsername(userCreate.username());
        userEntity.setName(userCreate.name());
        userEntity.setSurname(userCreate.surname());
        userEntity.setEmail(userCreate.email());
        userEntity.setPassword(userCreate.password());
        userEntity.setUserRole(userCreate.userRole());
        userEntity.setUserStatus(UserStatus.PENDING);
        return userJpaRepository.save(userEntity).toModel();
    }

    @Override
    public User retrieve(Long id) {
        return userJpaRepository.findById(id)
                .map(UserEntity::toModel)
                .orElseThrow(() -> new ThenutApiDataNotFoundException("thenutapi.user.notFound"));
    }

    @Override
    public User retrieve(String username) {
        return userJpaRepository.findByUsername(username)
                .map(UserEntity::toModel)
                .orElseThrow(() -> new ThenutApiDataNotFoundException("thenutapi.user.notFound"));
    }
}
