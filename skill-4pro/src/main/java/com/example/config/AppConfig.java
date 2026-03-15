package com.example.config;

import com.example.student.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "studentAnnotationConstructor")
    public Student studentAnnotationConstructor() {
        return new Student(201, "Alice Johnson", "Microservices", "2026");
    }

    @Bean(name = "studentAnnotationSetter")
    public Student studentAnnotationSetter() {
        Student student = new Student(202, "Charlie Brown", null, null);
        student.setCourse("REST APIs");
        student.setYear("2027");
        return student;
    }
}