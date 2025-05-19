package com.scaler.userservicedecmwfeve.repositories;

import com.scaler.userservicedecmwfeve.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
