package com.example.TeachTheWorld.Teach.the.World.Repository;

import com.example.TeachTheWorld.Teach.the.World.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
