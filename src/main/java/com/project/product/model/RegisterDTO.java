package com.project.product.model;

import org.apache.catalina.User;

public record RegisterDTO(String login, String senha, UserRoles role) {
}
