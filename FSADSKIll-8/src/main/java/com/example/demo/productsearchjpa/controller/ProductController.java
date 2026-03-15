package com.example.demo.productsearchjpa.controller;

import com.example.demo.productsearchjpa.entity.Product;
import com.example.demo.productsearchjpa.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    // 1. Category search (Derived method)
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }
    
    // 2. Price range filter (Derived method)
    @GetMapping("/filter")
    public List<Product> getProductsByPriceRange(
            @RequestParam double min, 
            @RequestParam double max) {
        return productRepository.findByPriceBetween(min, max);
    }
    
    // 3. Sorted by price (JPQL)
    @GetMapping("/sorted")
    public List<Product> getProductsSortedByPrice() {
        return productRepository.findAllSortedByPrice();
    }
    
    // 4. Products above price (JPQL)
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
    
    // 5. All products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}