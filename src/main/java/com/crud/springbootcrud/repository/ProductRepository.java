package com.crud.springbootcrud.repository;

import com.crud.springbootcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<Product,Integer> arg1 => entity name, arg2 => Primary key Datatype
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
