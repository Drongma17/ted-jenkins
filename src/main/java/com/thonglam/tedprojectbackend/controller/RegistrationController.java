package com.thonglam.tedprojectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.User;
import com.thonglam.tedprojectbackend.service.UserService;


@RestController
public class RegistrationController {


    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody User user){
        User dbUser=userService.save(user);
        if(dbUser !=null){
            return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
        }
        return null;
    }
}
