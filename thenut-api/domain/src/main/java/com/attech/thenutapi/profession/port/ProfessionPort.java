package com.attech.thenutapi.profession.port;

import com.attech.thenutapi.profession.model.Profession;
import com.attech.thenutapi.profession.usecase.ProfessionApplicationCreate;

import java.util.List;

public interface ProfessionPort {
    List<Profession> retrieveAll();
    void create(String profession);
    void createApplication(ProfessionApplicationCreate professionApplicationCreate);
}
