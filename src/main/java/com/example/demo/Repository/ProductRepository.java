package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("product")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
