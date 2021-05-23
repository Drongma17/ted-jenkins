package com.thonglam.tedprojectbackend.controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thonglam.tedprojectbackend.dto.User;
import com.thonglam.tedprojectbackend.service.UserService;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers(){
      List<User> users =userService.findAll();
      return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }




    @GetMapping(value = "/getuser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUser(Principal principal){
        User user =userService.getUserByEmail(principal.getName());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }



    @PutMapping("/user/{userId}")
    Optional<User> updateUser(@PathVariable Long userId, @Valid @RequestBody User userPerson){
        return userService.updateUser(userId, userPerson);
    }


    @DeleteMapping("/deleteUser/{userId}")
    public Optional<String> deleteUser(@PathVariable Long userId){
     return userService.deleteUser(userId);
    }

}
