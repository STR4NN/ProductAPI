package com.project.product;

import com.project.product.Security.TokenService;
import com.project.product.model.ProductModel;
import com.project.product.model.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
