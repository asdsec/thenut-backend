package com.attech.thenutapi.adapters.profession.jpa.repository;

import com.attech.thenutapi.adapters.profession.jpa.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionJpaRepository extends JpaRepository<ProfessionEntity, Long> {
}
