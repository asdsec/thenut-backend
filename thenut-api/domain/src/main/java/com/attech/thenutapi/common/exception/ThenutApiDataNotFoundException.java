package com.attech.thenutapi.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception class to indicate that data was not found in the Thenut API.
 */
@Getter
@Setter
public class ThenutApiDataNotFoundException extends RuntimeException {
    /**
     * The key associated with the data not found exception, typically used for error message lookup.
     */
    private final String key;

    /**
     * Additional arguments or parameters related to the exception, if needed.
     */
    private final String[] args;

    /**
     * Constructs a new ThenutApiDataNotFoundException with the specified key.
     *
     * @param key The key associated with the data not found exception, typically used for error message lookup.
     */
    public ThenutApiDataNotFoundException(String key) {
        super(key);
        this.key = key;
        this.args = new String[0];
    }

    /**
     * Constructs a new ThenutApiDataNotFoundException with the specified key and additional arguments.
     *
     * @param key   The key associated with the data not found exception, typically used for error message lookup.
     * @param args  Additional arguments or parameters related to the exception, if needed.
     */
    public ThenutApiDataNotFoundException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}
