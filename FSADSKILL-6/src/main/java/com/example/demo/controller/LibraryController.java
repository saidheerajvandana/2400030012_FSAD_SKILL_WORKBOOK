package com.example.demo.controller;

import com.example.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }
}