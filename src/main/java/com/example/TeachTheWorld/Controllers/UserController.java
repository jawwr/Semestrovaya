package com.example.TeachTheWorld.Controllers;

import com.example.TeachTheWorld.Models.User;
import com.example.TeachTheWorld.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
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
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body("Пользователь успешно сохранен");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserById(@RequestParam Long id){
        try{
            userService.deleteById(id);
            return ResponseEntity.ok().body("Пользователь успешно удален");
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}