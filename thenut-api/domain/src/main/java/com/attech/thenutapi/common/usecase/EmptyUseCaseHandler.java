package com.attech.thenutapi.common.usecase;

/**
 * The EmptyUseCaseHandler interface defines a contract for handling empty or parameterless use cases in the hexagonal architecture of the Thenut API.
 * <p>
 * Empty use case handlers are responsible for executing use cases that do not require any parameters and returning results or responses.
 * They act as intermediaries between application components and these parameterless use cases.
 *
 * @param <E> The type representing the result or response of executing the empty use case.
 */
public interface EmptyUseCaseHandler<E> {
    /**
     * Handle an empty or parameterless use case and return the result or response.
     *
     * @return The result or response of executing the empty use case.
     */
    E handle();
}
