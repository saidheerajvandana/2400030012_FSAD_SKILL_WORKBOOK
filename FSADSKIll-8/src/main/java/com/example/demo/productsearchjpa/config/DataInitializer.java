package com.example.demo.productsearchjpa.config;

import com.example.demo.productsearchjpa.entity.Product;
import com.example.demo.productsearchjpa.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.save(new Product("iPhone 15", "Electronics", 999.99));
            repository.save(new Product("MacBook Pro", "Electronics", 1999.99));
            repository.save(new Product("Samsung TV", "Electronics", 799.99));
            repository.save(new Product("Nike Shoes", "Clothing", 129.99));
            repository.save(new Product("Levis Jeans", "Clothing", 89.99));
            repository.save(new Product("Adidas Jacket", "Clothing", 199.99));
            repository.save(new Product("Coffee Maker", "Home", 49.99));
            repository.save(new Product("Microwave", "Home", 149.99));
        };
    }
}