package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course saved = service.create(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        return ResponseEntity.ok(service.update(id, course));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}