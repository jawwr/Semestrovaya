package com.example.TeachTheWorld.Services;

import com.example.TeachTheWorld.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    void deleteById(Long id);
    void save(User user);
    User getAuthenticationUser();
}
