package com.example.Controller;

import com.example.DTO.UserRes;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String callingHi() {
        return "This is the calling from postman ";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    @GetMapping("/findall")
    public List<UserRes> findAllUsers(){ return userService.getAllUsers();}

    @PostMapping("/register")
    public UserRes registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserRes getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/{name}")
    public UserRes findByUsername(@PathVariable String name){
        return userService.findByUsername(name);
    }
}
