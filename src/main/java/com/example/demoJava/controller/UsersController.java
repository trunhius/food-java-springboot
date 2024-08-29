package com.example.demoJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJava.service.imp.UserServiceImp;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {

        return new ResponseEntity<>(userServiceImp.getAllUser(), HttpStatus.OK);
    }
}
