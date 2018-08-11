package com.example.demo.Services.impl;

import com.example.demo.Model.Supplier;

import com.example.demo.Repository.SupplierRepository;
import com.example.demo.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

  
}
