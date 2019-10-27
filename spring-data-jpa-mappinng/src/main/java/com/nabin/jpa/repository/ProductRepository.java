package com.nabin.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabin.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
