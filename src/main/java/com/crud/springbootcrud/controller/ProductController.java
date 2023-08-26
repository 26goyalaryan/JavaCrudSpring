package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.entity.Product;
import com.crud.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/productByName/{name}")
    public Product findByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProducts(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        return new ResponseEntity<>(productService.saveProducts(products), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.removeProduct(id);
    }
}