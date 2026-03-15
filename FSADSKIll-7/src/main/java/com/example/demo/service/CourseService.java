package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public Course create(Course course) {
        return repository.save(course);
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    public Course update(Long id, Course course) {
        Course existing = getById(id);
        existing.setTitle(course.getTitle());
        existing.setDuration(course.getDuration());
        existing.setFee(course.getFee());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        repository.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}