package com.scaler.userservicedecmwfeve.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private int age;
    private String firstName;
    private String lastName;
    private String email;
}
