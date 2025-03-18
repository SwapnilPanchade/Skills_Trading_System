package com.example.service;

import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }
}
