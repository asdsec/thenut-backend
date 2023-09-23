package com.attech.thenutapi.common.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The ErrorResponse class represents an error response in the Thenut API infrastructure module.
 * <p>
 * This class encapsulates information about an error, including an error code and an error description.
 * It is used to provide structured error information in response to API requests.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    /**
     * Get the error code associated with this error response.
     */
    private String errorCode;

    /**
     * Get the error description associated with this error response.
     */
    private String errorDescription;
}
