package com.example.service;

import com.example.Controller.MatchController;
import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final UserRepo userRepo;
    MatchService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getMatchedUsers(long id) {
        User ogUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        List<User> allUsers = userRepo.findAll();

        List<User> matchedUsers = new ArrayList<>();

        for(User user : allUsers){
            if(ogUser.getId() == user.getId()) continue;
            boolean candidateOffersSkills = user.getOfferedSkills().stream().anyMatch(skill -> ogUser.getDesiredSkills().contains(skill));

            boolean candidateDesiredSkills = user.getDesiredSkills().stream().anyMatch(skill -> ogUser.getOfferedSkills().contains(skill));

            if(candidateDesiredSkills && candidateOffersSkills) matchedUsers.add(user);
        }
        return matchedUsers;
    }
}
