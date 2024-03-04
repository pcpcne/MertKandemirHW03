package com.example.mertkandemirhw03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int ProductID;

    @Column(name = "product_name")
    private String ProductName;

    @Column(name = "product_photo_url")
    private String ProductPhotoUrl;

    @Column(name = "product_description")
    private String ProductDescription;

    @Column(name = "product_price")
    private String ProductPrice;

    @Column(name = "product_category")
    private String ProductCategory;
}
