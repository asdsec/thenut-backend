package com.attech.thenutapi.common.usecase;

import com.attech.thenutapi.common.model.UseCase;

/**
 * The UseCaseHandler interface defines a generic contract for handling use cases in the hexagonal architecture of the Thenut API.
 * <p>
 * Use case handlers are responsible for executing specific use cases and returning results or responses.
 * They act as intermediaries between application components and the use cases.
 *
 * @param <E> The type representing the result or response of executing a use case.
 * @param <T> The type of the use case to be handled, which should implement the UseCase interface.
 */
public interface UseCaseHandler<E, T extends UseCase> {
    /**
     * Handle a specific use case and return the result or response.
     *
     * @param useCase The use case to be executed.
     * @return The result or response of executing the use case.
     */
    E handle(T useCase);
}
