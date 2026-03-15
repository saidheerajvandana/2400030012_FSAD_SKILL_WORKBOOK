package com.example.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student s1 = context.getBean("studentAnnotationConstructor", Student.class);
        System.out.println("Constructor Injection: " + s1);

        Student s2 = context.getBean("studentAnnotationSetter", Student.class);
        System.out.println("Setter Injection: " + s2);
    }
}