package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    private int productId;
    private String productName;
    private int price;

}
