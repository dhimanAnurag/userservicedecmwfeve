package com.scaler.userservicedecmwfeve.security.services;

import com.scaler.userservicedecmwfeve.models.User;
import com.scaler.userservicedecmwfeve.repositories.UserRepository;
import com.scaler.userservicedecmwfeve.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User by email: " + username + " doesn't exist.");
        }

        CustomUserDetails userDetails = new CustomUserDetails(userOptional.get());

        return userDetails;
    }
}