package com.scaler.userservicedecmwfeve.services;


import com.scaler.userservicedecmwfeve.exceptions.UserNotExistsException;
import com.scaler.userservicedecmwfeve.models.Users;
import com.scaler.userservicedecmwfeve.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("mysqlUserService")

public class MysqlUserService implements UserService {
    private final UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public MysqlUserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public Users addNewProduct(Users users) {
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public Users getUserById(Long id) throws UserNotExistsException {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException("User not exists with ID: " + id);
        }
        return optionalUser.get();
    }

    @Override
    public Users deleteUserById(Long id) throws UserNotExistsException {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException("User not exists with ID: " + id);
        }
        Users userToDelete = optionalUser.get();
        userRepository.deleteById(id);
        return userToDelete;
    }

    @Override
    public Users updateUserById(Long id,Users user) throws UserNotExistsException {
        Optional<Users> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException("User not exists with ID: " + user.getId());
        }
        Users userToUpdate = optionalUser.get();
        userToUpdate.setFirstName(user.getFirstName());

        return userRepository.save(userToUpdate);
    }

}