package com.attech.thenut.common.usecase;

import com.attech.thenut.common.model.UseCase;

public interface UseCaseHandler<T, U extends UseCase> {
    T handle(U useCase);
}
