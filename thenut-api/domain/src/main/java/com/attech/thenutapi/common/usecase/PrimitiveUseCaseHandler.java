package com.attech.thenutapi.common.usecase;

/**
 * The PrimitiveUseCaseHandler interface defines a contract for handling use cases that require a single primitive parameter in the hexagonal architecture of the Thenut API.
 * <p>
 * Primitive use case handlers are responsible for executing use cases that take a single primitive parameter of type {@code T}
 * and returning results or responses.
 * They act as intermediaries between application components and these parameterized use cases.
 *
 * @param <E> The type representing the result or response of executing the primitive use case.
 * @param <T> The type of the single primitive parameter expected by the use case.
 */
public interface PrimitiveUseCaseHandler<E, T> {
    /**
     * Handle a use case that requires a single primitive parameter and return the result or response.
     *
     * @param value The single primitive parameter required by the use case.
     * @return The result or response of executing the primitive use case.
     */
    E handle(T value);
}
