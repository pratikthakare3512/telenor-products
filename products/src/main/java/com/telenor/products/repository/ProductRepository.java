package com.telenor.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telenor.products.products.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
