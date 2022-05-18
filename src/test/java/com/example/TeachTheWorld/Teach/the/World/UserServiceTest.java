package com.example.TeachTheWorld.Teach.the.World;

import com.example.TeachTheWorld.Teach.the.World.Models.User;
import com.example.TeachTheWorld.Teach.the.World.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void getPeopleByIdTest(){
        User user1 = new User();
        user1.setName("John");
        User user2 = new User();
        user2.setName("James");

        userRepository.save(user1);
        userRepository.save(user2);

        var equalsUser = userRepository.getById(2L);
        assertEquals("James",equalsUser.getName());
    }
}
