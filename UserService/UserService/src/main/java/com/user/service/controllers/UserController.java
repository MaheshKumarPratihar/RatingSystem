package com.user.service.controllers;

import com.user.service.entities.User;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){
        User newUser =  this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = this.userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = this.userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteHotel(@RequestParam String id){
        return ResponseEntity.ok(this.userService.deleteUser(id));
    }



}
