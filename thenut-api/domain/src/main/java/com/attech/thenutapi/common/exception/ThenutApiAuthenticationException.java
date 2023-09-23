package com.attech.thenutapi.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThenutApiAuthenticationException extends RuntimeException {
    /**
     * The key associated with the business exception, typically used for error message lookup.
     */
    private final String key;

    /**
     * Additional arguments or parameters related to the exception, if needed.
     */
    private final String[] args;

    /**
     * Constructs a new ThenutApiBusinessException with the specified key.
     *
     * @param key The key associated with the business exception, typically used for error message lookup.
     */
    public ThenutApiAuthenticationException(String key) {
        super(key);
        this.key = key;
        args = new String[0];
    }

    /**
     * Constructs a new ThenutApiBusinessException with the specified key and additional arguments.
     *
     * @param key   The key associated with the business exception, typically used for error message lookup.
     * @param args  Additional arguments or parameters related to the exception, if needed.
     */
    public ThenutApiAuthenticationException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}
