package com.scaler.userservicedecmwfeve.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private int age;
    private String firstName;
    private String lastName;
    private String email;
}
