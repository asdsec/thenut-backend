package com.attech.thenutapi.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * The AbstractEntity class serves as the base entity for database entities in the Thenut API infrastructure module.
 * <p>
 * This class defines common fields and behavior shared by database entities, including an identifier (`id`),
 * creation timestamp (`createdAt`), and last modification timestamp (`updatedAt`).
 * It also utilizes JPA annotations for entity mapping and Spring Data's auditing support.
 * <p>
 * Entities in the infrastructure module extend this class to inherit standard fields and auditing functionality.
 * <p>
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.MappedSuperclass
 * @see org.springframework.data.annotation.CreatedDate
 * @see org.springframework.data.annotation.LastModifiedDate
 * @see org.springframework.data.jpa.domain.support.AuditingEntityListener
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    /**
     * The unique identifier of the entity.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The timestamp representing when the entity was created.
     */
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * The timestamp representing when the entity was last modified.
     */
    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;
}
