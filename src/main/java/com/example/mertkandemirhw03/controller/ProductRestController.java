package com.example.mertkandemirhw03.controller;

import com.example.mertkandemirhw03.entity.Product;
import com.example.mertkandemirhw03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        productRepository.save(product);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/{category}")
    public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String category){
        List<Product> products = productRepository.findByCategory(category);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
