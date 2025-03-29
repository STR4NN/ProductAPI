package com.project.product.controller;

import com.project.product.model.ProductModel;
import com.project.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // Permite requisições de qualquer dominio.
@RestController
@RequestMapping("/store")

public class ProductController {
    ProductService productsService;

    public ProductController(ProductService service) {
        this.productsService = service;
    }
    // Lista os produtos.
    @GetMapping("/test")
    public String testAPI() {
        return "API funcionando!";
    }
    @GetMapping
    public List<ProductModel> listProducts() {
       return productsService.listProducts();

    }
    @GetMapping("/{id}")
        public List<ProductModel> listProductsById() {
            return productsService.listProducts();

    }
    // Adiciona informações externas para o BD.
    @PostMapping
    public ProductModel createProducts(@RequestBody  ProductModel productModel){
        return  productsService.createProducts(productModel);
    }
    // Metodo para atualizar informações da API via ID.
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id,
                              @RequestBody ProductModel updatedProduct
                                     /* @RequestParam String name,
                                      @RequestParam String description,
                                      @RequestParam double price,
                                      @RequestParam int quantity*/
                                      ){
          productsService.updateProduct(id,updatedProduct);
          listProducts();
    }

    // Metodo para deletar dados da API.
    @DeleteMapping("/{id}")
    public List<ProductModel> deleteProduct(@PathVariable Long id){
        productsService.deleteProduct(id);
        return listProducts();
    }
}
