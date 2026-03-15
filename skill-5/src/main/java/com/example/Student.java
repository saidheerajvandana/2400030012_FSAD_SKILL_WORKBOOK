package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 201;
    private String name = "Alice Johnson";
    private String gender = "Female";

    @Autowired
    private Certification certification;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public Certification getCertification() { return certification; }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gender='" + gender + "', " + certification + "}";
    }
}