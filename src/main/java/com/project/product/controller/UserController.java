package com.project.product.controller;

import com.project.product.Security.TokenService;
import com.project.product.model.UserModel;
import com.project.product.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class UserController {
    UserService userService;
    TokenService tokenService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> listUsers(){

        return userService.listUsers();
    }
    @PostMapping
    public UserModel createUsers(@RequestBody UserModel user){
        return userService.createUsers(user);
    }
}
