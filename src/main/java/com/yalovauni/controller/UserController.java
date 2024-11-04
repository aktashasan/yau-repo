package com.yalovauni.controller;

import com.yalovauni.model.User;
import com.yalovauni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {



    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get/{username}")
    public String getUser(@PathVariable String username) {

        userRepository.findByUsername(username);

        System.out.println(username);
        return username;
    }

    @PostMapping("/add")
    public String addUser(User user) {

        userRepository.save(user);

        return "User added";
    }
}
