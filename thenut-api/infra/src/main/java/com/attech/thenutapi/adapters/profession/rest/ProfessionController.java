package com.attech.thenutapi.adapters.profession.rest;

import com.attech.thenutapi.adapters.profession.rest.dto.ProfessionApplicationCreateRequest;
import com.attech.thenutapi.adapters.profession.rest.dto.ProfessionResponse;
import com.attech.thenutapi.common.rest.BaseController;
import com.attech.thenutapi.common.rest.DataResponse;
import com.attech.thenutapi.common.usecase.EmptyUseCaseHandler;
import com.attech.thenutapi.common.usecase.UseCaseHandler;
import com.attech.thenutapi.profession.model.Profession;
import com.attech.thenutapi.profession.usecase.ProfessionApplicationCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Add validation

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/professions")
public class ProfessionController extends BaseController {
    private final EmptyUseCaseHandler<List<Profession>> professionRetrieveAllUseCaseHandler;
    private final UseCaseHandler<Void, ProfessionApplicationCreate> professionApplicationCreateUseCaseHandler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DataResponse<ProfessionResponse> getAllProfessions() {
        var professions = professionRetrieveAllUseCaseHandler.handle();
        return respond(ProfessionResponse.from(professions)).getData();
    }

    @PostMapping("/applications")
    @ResponseStatus(HttpStatus.CREATED)
    public void applyForProfession(@RequestBody ProfessionApplicationCreateRequest request) {
        professionApplicationCreateUseCaseHandler.handle(request.toUseCase());
    }
}
