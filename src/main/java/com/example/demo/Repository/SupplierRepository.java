package com.example.demo.Repository;

import com.example.demo.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SupplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
