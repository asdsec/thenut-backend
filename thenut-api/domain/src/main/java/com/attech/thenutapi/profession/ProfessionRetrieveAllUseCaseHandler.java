package com.attech.thenutapi.profession;

import com.attech.thenutapi.common.DomainComponent;
import com.attech.thenutapi.common.usecase.EmptyUseCaseHandler;
import com.attech.thenutapi.common.usecase.PrimitiveUseCaseHandler;
import com.attech.thenutapi.profession.model.Profession;
import com.attech.thenutapi.profession.port.ProfessionPort;
import com.sun.jdi.VoidValue;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainComponent
@RequiredArgsConstructor
public class ProfessionRetrieveAllUseCaseHandler implements EmptyUseCaseHandler<List<Profession>> {

    private final ProfessionPort professionPort;

    @Override
    public List<Profession> handle() {
        return professionPort.retrieveAll();
    }
}
