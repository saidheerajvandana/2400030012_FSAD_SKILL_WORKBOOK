package com.example.student;

public class Student {

    private int studentId;
    private String name;
    private String course;
    private String year;

    public Student() {
    }

    public Student(int studentId, String name, String course, String year) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String toString() {
        return studentId + " " + name + " " + course + " " + year;
    }
}