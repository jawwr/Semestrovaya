package com.example.TeachTheWorld.Security;

import com.example.TeachTheWorld.Models.User;
import com.example.TeachTheWorld.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userNickname) throws UsernameNotFoundException {
        User user = repository.findByNickname(userNickname);
        return SecurityUser.valueOf(user);
    }
}
