package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;

import com.example.app.exception.UserNotFoundException;

@RestController
public class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) 
  {
    this.repository = repository;
  }

  @GetMapping("/user")
  List<User> all() 
  {
    return repository.findAll();
  }

  @PostMapping("/user")
  User newUser(@RequestBody User newUser) 
  {
    return repository.save(newUser);
  }

  // Single item

  @GetMapping("/user/{id}")
  User one(@PathVariable Long id) 
  {
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/user/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Long id) 
  {
    return repository.findById(id)
      .map(user -> {
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        return repository.save(user);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) 
  {
    repository.deleteById(id);
  }
}