package com.example;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private String course = "Java Spring Boot";

    public String toString() {
        return "Certification{course='" + course + "'}";
    }
}