package com.example.Controller;

import com.example.entity.User;
import com.example.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final MatchService matchService;

    MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public List<User> getMatchedUsers(@PathVariable long id){
        return matchService.getMatchedUsers(id);
    }
}
