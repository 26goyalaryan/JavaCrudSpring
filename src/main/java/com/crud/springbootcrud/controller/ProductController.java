package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.entity.Product;
import com.crud.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product findById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @PutMapping("/update")
    public Product update(Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.removeProduct(id);
    }
}
