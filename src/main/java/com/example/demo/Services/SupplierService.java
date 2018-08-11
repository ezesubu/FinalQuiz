package com.example.demo.Services;

import com.example.demo.Model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier save(Supplier supplier);
}
