package com.project.product.service;

import com.project.product.model.UserModel;
import com.project.product.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> listUsers(){
        return userRepository.findAll();
    }
    public UserModel createUsers(UserModel user){
        return userRepository.save(user);
    }
}
