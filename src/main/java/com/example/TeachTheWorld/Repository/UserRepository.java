package com.example.TeachTheWorld.Repository;

import com.example.TeachTheWorld.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
