package com.example.TeachTheWorld.Teach.the.World.Services;

import com.example.TeachTheWorld.Teach.the.World.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    void deleteById(Long id);
    void save(User user);
}
