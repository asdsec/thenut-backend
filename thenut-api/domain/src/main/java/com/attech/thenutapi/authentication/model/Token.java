package com.attech.thenutapi.authentication.model;

import lombok.Builder;

@Builder
public record Token(
        String token,
        Integer expiresIn
) {
}
