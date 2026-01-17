package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(1, "camera", 10000),
            new Product(2, "computer", 20000),
            new Product(3, "glasses", 50000)
    );

    public List<Product> getProducts() {
        return products;
    }
}
