package com.attech.thenutapi.adapters.profession.jpa;

import com.attech.thenutapi.adapters.profession.jpa.entity.ProfessionApplicationEntity;
import com.attech.thenutapi.adapters.profession.jpa.entity.ProfessionEntity;
import com.attech.thenutapi.adapters.profession.jpa.repository.ProfessionApplicationJpaRepository;
import com.attech.thenutapi.adapters.profession.jpa.repository.ProfessionJpaRepository;
import com.attech.thenutapi.profession.model.ApplicationStatus;
import com.attech.thenutapi.profession.model.Profession;
import com.attech.thenutapi.profession.port.ProfessionPort;
import com.attech.thenutapi.profession.usecase.ProfessionApplicationCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionDataAdapter implements ProfessionPort {

    private final ProfessionJpaRepository professionJpaRepository;
    private final ProfessionApplicationJpaRepository professionApplicationJpaRepository;

    @Override
    public List<Profession> retrieveAll() {
        return professionJpaRepository.findAll()
                .stream().map(ProfessionEntity::toModel).toList();
    }

    @Override
    public void create(String profession) {
        var professionEntity = new ProfessionEntity();
        professionEntity.setName(profession);
        professionJpaRepository.save(professionEntity);
    }

    @Override
    public void createApplication(ProfessionApplicationCreate professionApplicationCreate) {
        var professionApplicationEntity = new ProfessionApplicationEntity();
        professionApplicationEntity.setProfession(professionApplicationCreate.profession());
        professionApplicationEntity.setUserId(professionApplicationCreate.userId());
        professionApplicationEntity.setApplicationStatus(ApplicationStatus.PENDING);
        professionApplicationJpaRepository.save(professionApplicationEntity);
    }
}
