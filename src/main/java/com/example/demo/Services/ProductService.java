package com.example.demo.Services;

import com.example.demo.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product student);
}
