package com.example.main;

import com.example.dao.ProductDAO;
import com.example.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // 1️⃣ Insert product
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 5);
        dao.addProduct(p1);
        System.out.println("Product inserted successfully");

        // 2️⃣ Retrieve product
        Product p = dao.getProduct(1);
        if (p != null) {
            System.out.println("Product Name: " + p.getName());
        }

        // 3️⃣ Update product price
        dao.updateProduct(1, 80000);
        System.out.println("Product updated successfully");

        // 4️⃣ Delete product (optional)
        // dao.deleteProduct(1);
        // System.out.println("Product deleted successfully");

    }
}