package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "camera", 10000),
            new Product(2, "computer", 20000),
            new Product(3, "glasses", 50000)
    ));


    public Product getProductById(int productId) {
        return products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst().orElseThrow(() -> new RuntimeException("Product not found: " + productId));
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
