package com.example.service;

import com.example.DTO.UserRes;
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

    public UserRes addUser(User user) {
        User u = userRepo.save(user);
        UserRes res = new UserRes();
        res.setId(u.getId());
        res.setName(u.getName());
        res.setEmail(u.getEmail());
        res.setSkills(u.getSkills());
        return res;
    }
}
