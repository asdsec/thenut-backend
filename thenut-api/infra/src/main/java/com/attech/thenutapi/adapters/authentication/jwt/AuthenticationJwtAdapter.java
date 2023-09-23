package com.attech.thenutapi.adapters.authentication.jwt;

import com.attech.thenutapi.adapters.user.jpa.entity.UserEntity;
import com.attech.thenutapi.authentication.model.Authentication;
import com.attech.thenutapi.authentication.model.Token;
import com.attech.thenutapi.authentication.port.AuthenticationPort;
import com.attech.thenutapi.configuration.JwtService;
import com.attech.thenutapi.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationJwtAdapter implements AuthenticationPort {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication authenticate(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.email(),
                        user.password()
                )
        );
        var jwtTokenString = jwtService.generateToken(user);
        Token token = buildToken(jwtTokenString);
        return buildAuthentication(user, token);
    }

    private Token buildToken(String jwtTokenString) {
        return Token.builder()
                .token(jwtTokenString)
                .expiresIn(jwtService.getAccessTokenDuration())
                .build();
    }

    private Authentication buildAuthentication(User user, Token token) {
        return Authentication.builder()
                .username(user.username())
                .email(user.email())
                .enabled(user.enabled())
                .token(token)
                .build();
    }
}
