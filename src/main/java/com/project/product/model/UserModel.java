package com.project.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Entity
@Table(name = "usuario")
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private UserRoles role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Quais são as ROLES

        // Se Role == ADMIN, ele ganha permissoes de ADMIN e de USER também
        if(this.role == UserRoles.ADMIN) return List.of(new SimpleGrantedAuthority
                ("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));


        else{ // Se não, ganha apenas permissoes de USER
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }

    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
