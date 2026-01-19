package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private String brand;

    @Setter
    private BigDecimal price;

    @Setter
    private String category;

//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Setter
    private LocalDate releaseDate;

    @Setter
    private boolean productAvailable;

    @Setter
    private int stockQuantity;

    @Setter
    private String imageName;

    @Setter
    private String imageType;

    @Setter
    @Lob
    private byte[] imageData;

    protected Product() {}

    // 생성자에 필드 추가 -> 필수값을 강제로 넣게 해서 객체 안정성 증가.
    // 파일 업로드는 별 프로세스. 상품 생성 시 이미지를 나중에 업로드하는 상황이 훨씬 많음
    private Product(String name, String description, String brand, BigDecimal price, String category, LocalDate releaseDate, boolean productAvailable, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
        this.productAvailable = productAvailable;
        this.stockQuantity = stockQuantity;
    }

    public Product of(String name, String description, String brand, BigDecimal price, LocalDate releaseDate, String category, boolean available, int quantity) {
        return new Product(name, description, brand, price, category, releaseDate, available, quantity);
    }
}
