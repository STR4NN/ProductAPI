package com.project.product.service;

import com.project.product.model.ProductModel;
import com.project.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<ProductModel> listProducts(){
        return productRepository.findAll();
    }

    public ProductModel createProducts(ProductModel productModel){
        listProducts();
        return productRepository.save(productModel);
    }

    public ProductModel updateProduct(@PathVariable  Long id, ProductRepository repository){
        listProducts();
        productRepository.findById(id);
        Optional<>
       productRepository.saveAll();
        return

    }

    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        listProducts();
    }
}
