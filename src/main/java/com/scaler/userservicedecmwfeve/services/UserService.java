package com.scaler.userservicedecmwfeve.services;

import com.scaler.userservicedecmwfeve.exceptions.UserNotExistsException;
import com.scaler.userservicedecmwfeve.models.Users;

import java.util.List;

public interface UserService {
    Users addNewProduct(Users users);
    List<Users> getAllUsers();
    Users getUserById(Long id);
    Users deleteUserById(Long id);
    Users updateUserById(Long id, Users user);
}
