package com.scaler.userservicedecmwfeve.services;


import com.scaler.userservicedecmwfeve.models.User;
import com.scaler.userservicedecmwfeve.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("mysqlUserService")

public class MysqlUserService implements UserService {
    private final UserRepository userRepository;

    public MysqlUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addNewProduct(User user){
        return userRepository.save(user);
    }
}
