package com.scaler.userservicedecmwfeve.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users extends BaseModel {
    private int age;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
