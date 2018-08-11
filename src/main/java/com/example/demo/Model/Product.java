package com.example.demo.Model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long productId;

        private Long productNumber;
        private String name;
        private Double unitPrice;
        private int quantityInStock;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dateSupplied;


        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "supplier_id", nullable = true)
        private Supplier supplier;


        public static long getSerialVersionUID() {
                return serialVersionUID;
        }

        public int getQuantityInStock() {
                return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
                this.quantityInStock = quantityInStock;
        }

        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public Long getId() {
                return productId;
        }

        public void setId(Long id) {
                this.productId = id;
        }

        public Supplier getSupplier() {
                return supplier;
        }

        public void setSupplier(Supplier supplier) {
                this.supplier = supplier;
        }

        public Long getProductNumber() {
                return productNumber;
        }

        public void setProductNumber(Long productNumber) {
                this.productNumber = productNumber;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Double getUnitPrice() {
                return unitPrice;
        }

        public void setUnitPrice(Double unitPrice) {
                this.unitPrice = unitPrice;
        }

        public Date getDateSupplied() {
                return dateSupplied;
        }

        public void setDateSupplied(Date dateSupplied) {
                this.dateSupplied = dateSupplied;
        }

}
