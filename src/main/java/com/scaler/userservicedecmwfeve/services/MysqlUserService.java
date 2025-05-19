package com.scaler.userservicedecmwfeve.services;


import com.scaler.userservicedecmwfeve.dtos.UserDto;
import com.scaler.userservicedecmwfeve.models.Users;
import com.scaler.userservicedecmwfeve.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

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

    private Users convertUserDtoToUser(UserDto userDto) {
        Users users = new Users();
        users.setId(userDto.getId());
        users.setAge(userDto.getAge());
        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setEmail(userDto.getEmail());
        users.setCreatedAt(LocalDateTime.now());
        users.setUpdatedAt(LocalDateTime.now());
        users.setCreatedBy(String.valueOf(userDto.getCreatedBy()));
        users.setUpdatedBy(String.valueOf(userDto.getUpdatedBy()));
        users.setIsDeleted(false);
        return users;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> allUsers = userRepository.findAll();
        System.out.println("hi I am all the user and having some trouble"+ allUsers);
        return allUsers;
//        UserDto userResponse[] = restTemplate.getForObject(
//                "http://localhost:8080/users", UserDto[].class
//        );
//        List<User> users = new ArrayList<>();
//
//        for(UserDto userDto : userResponse){
//            users.add(convertUserDtoToUser(userDto));
//        }
//        List<User> allUsers = userRepository.findAll();
//
//        return allUsers;

    }
}
