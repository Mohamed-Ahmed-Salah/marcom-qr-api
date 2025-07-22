package com.marcom.interview_taks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.marcom.interview_taks.dto.response.GeneralResponse;
import com.marcom.interview_taks.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping
    public GeneralResponse getAllUsers() {
        return userService.getAllUsers();
    }
}




