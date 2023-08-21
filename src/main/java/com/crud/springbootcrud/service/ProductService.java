package com.crud.springbootcrud.service;

import com.crud.springbootcrud.entity.Product;
import com.crud.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository; // this service will use this repository

    // ----------------------- PUT Methods ---------------------------------

    // Both save and savaAll methods are given by spring JPA
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // ----------------------- GET Methods ---------------------------------
    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null); // return the optional
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    // ----------------------- DELETE Methods ---------------------------------

    public String removeProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed || " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }
}
