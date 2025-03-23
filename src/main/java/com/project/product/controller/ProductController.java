package com.project.product.controller;

import com.project.product.model.ProductModel;
import com.project.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    ProductService productsService;

    public ProductController(ProductService service) {
        this.productsService = service;
    }
    // Lista os produtos.
    @GetMapping
    public List<ProductModel> listProducts() {
        return productsService.listProducts();

    }
    @PostMapping
    public ProductModel createProducts(@RequestBody  ProductModel productModel){
        return  productsService.createProducts(productModel);
    }
    @PutMapping
    public ProductModel updateProduct(){

    }
    @DeleteMapping("/{id}")
    public List<ProductModel> deleteProduct(@PathVariable Long id){
        productsService.deleteProduct(id);
        return listProducts();
    }
}
