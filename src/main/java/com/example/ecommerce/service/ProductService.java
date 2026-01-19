package com.example.ecommerce.service;

import com.example.ecommerce.exception.AddFailException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.exception.UpdateFailException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // setter로 product에 이미지 속성들을 저장
    public Product addProduct(Product product, MultipartFile imageFile) {

        if(imageFile != null && !imageFile.isEmpty()) {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            try {
                product.setImageData(imageFile.getBytes());
            } catch (IOException e) {
                throw new AddFailException(e);
            }
        }

        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product product, MultipartFile imageFile) {
        Product existingProduct =  productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setStockQuantity(product.getStockQuantity());

        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
            try {
                existingProduct.setImageData(imageFile.getBytes());
            } catch (IOException e) {
                throw new UpdateFailException(e);
            }
        }
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int productId) {
        Product productToDelete = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        productRepository.delete(productToDelete);
    }
}
