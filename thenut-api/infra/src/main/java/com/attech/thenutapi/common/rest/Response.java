package com.attech.thenutapi.common.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Response class represents a generic response in the Thenut API infrastructure module.
 * <p>
 * This class can encapsulate either data or error information in response to API requests.
 * It is a generic class, allowing flexibility in the type of data or error response it can hold.
 * <p>
 * @param <T> The type of data that can be encapsulated in the response.
 */
@Getter
@NoArgsConstructor
public class Response<T> {

    /**
     * The data encapsulated in the response.
     */
    private T data;

    /**
     * The error response encapsulated in the response.
     */
    private ErrorResponse errors;

    /**
     * Constructor for creating a response with error information.
     *
     * @param errors The error response to encapsulate.
     */
    public Response(ErrorResponse errors) {
        this.errors = errors;
    }

    /**
     * Constructor for creating a response with data.
     *
     * @param data The data to encapsulate.
     */
    public Response(T data) {
        this.data = data;
    }
}
