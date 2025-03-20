package com.example.service;

import com.example.DTO.UserRes;
import com.example.entity.Skills;
import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;
    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public List<UserRes> getAllUsers(){
        return userRepo.findAll().stream()
                .map(this::maptoUserres)
                .collect(Collectors.toList());
    }
    public UserRes addUser(User user) {
        User user1 = userRepo.save(user);
        return maptoUserres(user1);
    }

    public UserRes findById(long id) {
        User user = userRepo.findById(id).get();
        return maptoUserres(user);
    }

    public UserRes findByUsername(String name) {
        User user =  userRepo.findByUsername(name);
        return maptoUserres(user);

    }

    public UserRes maptoUserres(User user){
        UserRes res = new UserRes();
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setId(user.getId());
        res.setOfferedSkills(user.getOfferedSkills());
        res.setDesiredSkills(user.getDesiredSkills());
        return res;
    }
}
