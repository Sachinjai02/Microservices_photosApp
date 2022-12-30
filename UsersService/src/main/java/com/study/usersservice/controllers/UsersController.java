package com.study.usersservice.controllers;

import com.study.usersservice.dtos.CreateUserRequestDto;
import com.study.usersservice.models.User;
import com.study.usersservice.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private Environment env;

    @Autowired
    private UsersService usersService;
    @GetMapping("/status/check")
    public String status() {
        return "working on port : " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequestDto userReq) {
        User user = usersService.createService(userReq.toUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
