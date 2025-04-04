package com.project.product.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project.product.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
 private String secret;

    public String generateToken(UserModel user){

        try { // Cria o Token para autenticação

            // Algoritimo de decodificação
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("product") // Nome do aplicativo, quem esta emitindo
                    .withSubject(user.getEmail()) // Sujeito para quem sera gerado
                    .withExpiresAt(this.generateExpiresDate()) // Tempo de expiração do token
                    .sign(algorithm);// Sujeito
            System.out.println(token);
                return token;

        }
        catch (JWTCreationException exception) { // Lança exceção
             throw new RuntimeException("Error while authenticating");
        }
    }
    public String validateToken(String token){
        try{
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm).
                withIssuer("product")
                .build()
                .verify(token) // Decodifica o token criado
                .getSubject(); // Retorna o email

        } catch(JWTVerificationException e){
            return null;
        }

    }

    private Instant generateExpiresDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
        // Token ira durar 2 horas
    }
}
