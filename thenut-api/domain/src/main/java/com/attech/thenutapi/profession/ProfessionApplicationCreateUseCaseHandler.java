package com.attech.thenutapi.profession;

import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import com.attech.thenutapi.profession.port.ProfessionPort;
import com.attech.thenutapi.profession.usecase.ProfessionApplicationCreate;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class ProfessionApplicationCreateUseCaseHandler implements UseCaseHandler<Void, ProfessionApplicationCreate> {

    private final ProfessionPort professionPort;

    @Override
    public Void handle(ProfessionApplicationCreate useCase) {
        professionPort.createApplication(useCase);
        return null;
    }
}
