package com.tweteroo.tweteroo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dto.UserDTO;
import com.tweteroo.tweteroo.services.UserService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sign-up")
public class TweterooController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody @Valid UserDTO req){
        userService.create(req);
    }
    
}
