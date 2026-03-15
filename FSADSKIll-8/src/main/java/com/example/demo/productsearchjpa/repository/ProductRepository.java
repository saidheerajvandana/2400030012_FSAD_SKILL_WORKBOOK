package com.example.demo.productsearchjpa.repository;

import com.example.demo.productsearchjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Derived Query Methods
    List<Product> findByCategory(String category);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    
    // JPQL Queries
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();
    
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceGreaterThan(@Param("price") double price);
    
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductsByCategory(@Param("category") String category);
}