package com.project.product.service;

import com.project.product.model.ProductModel;
import com.project.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
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
        return productRepository.findAll(); // Select ALL
    }

    public ProductModel createProducts(ProductModel productModel){
        listProducts();
        return productRepository.save(productModel); // Insert Into
    }

    public void updateProduct(@PathVariable
          Long id, ProductModel updatedProduct ){

        Optional<ProductModel>  productModel =  productRepository.findById(id);

            if(productModel.isPresent()){
                ProductModel productModel1 = productModel.get();

                productModel1.setName(updatedProduct.getName());
                productModel1.setDescription(updatedProduct.getDescription());
                productModel1.setPrice(updatedProduct.getPrice());
                productModel1.setQuantity(updatedProduct.getQuantity());

                productRepository.save(productModel1);
            }else{
                throw new RuntimeException();
            }
        listProducts();
    }

    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        listProducts();
    }
}
