package com.example.lab8_6733800494_sec2.service;

import com.example.lab8_6733800494_sec2.model.Product;
import com.example.lab8_6733800494_sec2.repository.ProductRepository;
import com.example.lab8_6733800494_sec2.strategy.DiscountContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DiscountContext discountContext;

    public ProductService(ProductRepository productRepository, DiscountContext discountContext) {
        this.productRepository = productRepository;
        this.discountContext = discountContext;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public double getFinalPrice(Product product) {
        return discountContext.calculate(product.getDiscountType(), product.getPrice());
    }
}