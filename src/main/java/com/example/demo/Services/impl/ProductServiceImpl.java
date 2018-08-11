package com.example.demo.Services.impl;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }


}
