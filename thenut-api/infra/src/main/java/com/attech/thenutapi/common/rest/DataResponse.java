package com.attech.thenutapi.common.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * The DataResponse class represents a response containing a list of items in the Thenut API infrastructure module.
 * <p>
 * This class encapsulates a list of items, pagination information (page, size, and totalSize), and provides methods to access these components.
 * It is a generic class that can hold a list of items of any type.
 *
 * @param <T> The type of items contained in the response.
 */
@NoArgsConstructor
public class DataResponse<T> {

    /**
     * The list of items encapsulated in the response.
     */
    @Getter
    private List<T> items = List.of();

    /**
     * The page number of the response.
     */
    @Getter
    private Integer page;

    /**
     * The size (number of items per page) of the response.
     */
    private Integer size;

    /**
     * The total number of items available.
     */
    @Getter
    private Long totalSize;

    /**
     * Constructor for creating a data response with a list of items.
     *
     * @param items The list of items to encapsulate.
     */
    public DataResponse(List<T> items) {
        this.items = items;
    }

    /**
     * Constructor for creating a data response with a list of items and pagination information.
     *
     * @param items     The list of items to encapsulate.
     * @param page      The page number.
     * @param size      The size (number of items per page).
     * @param totalSize The total number of items available.
     */
    public DataResponse(List<T> items, Integer page, Integer size, Long totalSize) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalSize = totalSize;
    }

    /**
     * Get the effective size (number of items) of the response.
     * If the size is null, it returns the size of the items list.
     *
     * @return The effective size of the response.
     */
    public Integer getSize() {
        return Objects.nonNull(size) ? size : items.size();
    }
}
