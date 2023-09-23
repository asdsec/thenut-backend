package com.attech.thenutapi.adapters.user.jpa.entity;

import com.attech.thenutapi.common.entity.AbstractEntity;
import com.attech.thenutapi.user.model.User;
import com.attech.thenutapi.user.model.UserRole;
import com.attech.thenutapi.user.model.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !userStatus.equals(UserStatus.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !userStatus.equals(UserStatus.DISABLED);
    }

    public User toModel() {
        return User.builder()
                .id(super.getId())
                .username(username)
                .username(username)
                .email(email)
                .name(name)
                .surname(surname)
                .password(password)
                .userRole(userRole)
                .userStatus(userStatus)
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
                .build();
    }
}
