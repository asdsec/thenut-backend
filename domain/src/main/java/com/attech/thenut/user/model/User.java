package com.attech.thenut.user.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String imageUrl;
    private Character gender;
    private Boolean disabled;
    private LocalDateTime birthDate;
    private LocalDateTime passwordChangedAt;
    private LocalDateTime createdAt;

}