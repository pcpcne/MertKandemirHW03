package com.example.mertkandemirhw03.repository;

import com.example.mertkandemirhw03.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);

    List<Product> findByCategory(String category);
}
