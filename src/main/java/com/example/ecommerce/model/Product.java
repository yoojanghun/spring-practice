package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime releaseDate;
    private boolean available;
    private int quantity;

    protected Product() {}

    private Product(String name, String description, String brand, BigDecimal price, String category, LocalDateTime releaseDate, boolean available, int quantity) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
        this.available = available;
        this.quantity = quantity;
    }

    public Product of(String name, String description, String brand, BigDecimal price, LocalDateTime releaseDate, String category, boolean available, int quantity) {
        return new Product(name, description, brand, price, category, releaseDate, available, quantity);
    }
}
