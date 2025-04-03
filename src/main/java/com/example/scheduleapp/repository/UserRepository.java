package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
