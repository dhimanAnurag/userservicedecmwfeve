package com.scaler.userservicedecmwfeve.services;

import com.scaler.userservicedecmwfeve.models.Users;

import java.util.List;

public interface UserService {
    Users addNewProduct(Users users);
    List<Users> getAllUsers();
}
