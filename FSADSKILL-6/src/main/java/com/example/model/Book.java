package com.example.model;

public class Book {
    private int id;
    private String title;
    private double price;
    private String author;

    // Default constructor
    public Book() {}

    // Constructor with params
    public Book(int id, String title, double price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"title\":\"" + title + "\",\"price\":" + price + ",\"author\":\"" + author + "\"}";
    }
}