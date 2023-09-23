package com.attech.thenutapi.adapters.profession.jpa.entity;

import com.attech.thenutapi.common.entity.AbstractEntity;
import com.attech.thenutapi.profession.model.Profession;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professions")
public class ProfessionEntity extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    public Profession toModel() {
        return Profession.builder()
                .id(super.getId())
                .name(name)
                .createAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
                .build();
    }
}
