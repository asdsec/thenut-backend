package com.attech.thenutapi.authentication.model;

import lombok.Builder;

@Builder
public record Authentication(
        String username,
        String email,
        Boolean enabled,
        Token token
) {
}
