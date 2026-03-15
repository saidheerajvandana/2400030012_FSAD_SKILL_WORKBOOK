package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Skill5Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Skill5Application.class, args);

        Student student = context.getBean(Student.class);
        System.out.println(student);
    }
}