package com.example.TeachTheWorld.Teach.the.World.Controllers;

import com.example.TeachTheWorld.Teach.the.World.Models.User;
import com.example.TeachTheWorld.Teach.the.World.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam Long id){
        userService.deleteById(id);
    }
}
