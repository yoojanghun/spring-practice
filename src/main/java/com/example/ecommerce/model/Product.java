package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Getter
@Entity
public class Product {

    @Id
    private int id;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private LocalDateTime releaseDate;

    protected Product() {}

    private Product(String name, String description, String brand, BigDecimal price, String category, LocalDateTime releaseDate) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    public Product of(String name, String description, String brand, BigDecimal price, LocalDateTime releaseDate, String category) {
        return new Product(name, description, brand, price, category, releaseDate);
    }
}
