package com.yalovauni.controller;

import com.yalovauni.model.User;
import com.yalovauni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {



    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get/{username}")
    public User getUserByUsername(@PathVariable String username) {

        return userRepository.findByUsername(username);

    }

    //findAll
    @GetMapping("/findAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        userRepository.save(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
