package com.scaler.userservicedecmwfeve.services;


import com.scaler.userservicedecmwfeve.dtos.UserDto;
import com.scaler.userservicedecmwfeve.exceptions.UserNotExistsException;
import com.scaler.userservicedecmwfeve.models.Users;
import com.scaler.userservicedecmwfeve.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("mysqlUserService")

public class MysqlUserService implements UserService {
    private final UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public MysqlUserService(UserRepository userRepository, RestTemplate restTemplate ) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public Users addNewProduct(Users users){
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

}
