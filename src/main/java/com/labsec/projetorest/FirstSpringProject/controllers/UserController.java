package com.labsec.projetorest.FirstSpringProject.controllers;

import com.labsec.projetorest.FirstSpringProject.entities.User;
import com.labsec.projetorest.FirstSpringProject.repositories.UserRepository;
import com.labsec.projetorest.FirstSpringProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")


public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("users/getAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());

    }

    @GetMapping("users/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userRepository.findById(id);
    }


    @PutMapping("users/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user); // Passa o id e o objeto user
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}


