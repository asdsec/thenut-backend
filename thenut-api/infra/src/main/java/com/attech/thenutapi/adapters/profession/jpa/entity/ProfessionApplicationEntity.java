package com.attech.thenutapi.adapters.profession.jpa.entity;

import com.attech.thenutapi.common.entity.AbstractEntity;
import com.attech.thenutapi.profession.model.ApplicationStatus;
import com.attech.thenutapi.profession.model.ProfessionApplication;
import com.attech.thenutapi.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "profession_applications",
        indexes = {
                @Index(name = "idx_user", columnList = "userId", unique = true)
        }
)
public class ProfessionApplicationEntity extends AbstractEntity {

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private ApplicationStatus applicationStatus;

    public ProfessionApplication toModel() {
        return ProfessionApplication.builder()
                .id(super.getId())
                .profession(profession)
                .userId(userId)
                .applicationStatus(applicationStatus)
                .createdAt(super.getCreatedAt())
                .updateAt(super.getUpdatedAt())
                .build();
    }
}
