package com.attech.thenutapi.adapters.profession.jpa.repository;

import com.attech.thenutapi.adapters.profession.jpa.entity.ProfessionApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionApplicationJpaRepository  extends JpaRepository<ProfessionApplicationEntity, Long> {
}