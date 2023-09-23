package com.attech.thenutapi.common.rest;

import java.util.List;

/**
 * The BaseController class provides common methods for responding to API requests in the Thenut API infrastructure module.
 * <p>
 * This class contains methods for constructing responses that encapsulate data, pagination information, and error responses.
 * It is designed to be extended by specific controller classes to simplify response handling in RESTful APIs.
 *
 * @see ResponseBuilder
 */
public class BaseController {

    /**
     * Respond to an API request with a list of items.
     *
     * @param <T>   The type of items in the list.
     * @param items The list of items to include in the response.
     * @return A response encapsulating the list of items.
     */
    public <T> Response<DataResponse<T>> respond(List<T> items) {
        return ResponseBuilder.build(items);
    }

    /**
     * Respond to an API request with a list of items, including pagination information.
     *
     * @param <T>       The type of items in the list.
     * @param items     The list of items to include in the response.
     * @param page      The page number of the results.
     * @param size      The number of items per page.
     * @param totalSize The total number of items available.
     * @return A response encapsulating the list of items and pagination details.
     */
    public <T> Response<DataResponse<T>> respond(List<T> items, int page, int size, Long totalSize) {
        return ResponseBuilder.build(items, page, size, totalSize);
    }

    /**
     * Respond to an API request with a single item.
     *
     * @param <T>  The type of the item.
     * @param item The item to include in the response.
     * @return A response encapsulating the single item.
     */
    protected <T> Response<T> respond(T item) {
        return ResponseBuilder.build(item);
    }

    /**
     * Respond to an API request with an error response.
     *
     * @param errorResponse The error response to include in the response.
     * @return A response encapsulating the error response.
     */
    protected Response<ErrorResponse> respond(ErrorResponse errorResponse) {
        return ResponseBuilder.build(errorResponse);
    }
}
