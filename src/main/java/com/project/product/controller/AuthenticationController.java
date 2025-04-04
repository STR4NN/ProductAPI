package com.project.product.controller;

import com.project.product.model.AthenticationDTO;
import com.project.product.model.RegisterDTO;
import com.project.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AthenticationDTO data){

        // Não é uma boa pratica guardar a senha do banco de dados. O Padrão é criptografar.
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login() ,data.password());
        var auth =  this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/registar")
    ResponseEntity register(@RequestBody RegisterDTO data){
        if(this.userRepository.findByEmail(data.login()) != null)) return ResponseEntity.badRequest().build();
    }
}
