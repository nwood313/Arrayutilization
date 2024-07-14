package com.coderscampus.array4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read students from the CSV file
        Student[] students = FileService.readStudents("student masterlist.csv");
        // Sort students by course and grade
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());

        // Write students to course-specific CSV files

        FileService.writeStudents(Arrays.stream(students).filter(s -> s.getCourse().contains("COMPSCI")).toArray(Student[]::new), "course1.csv");
        FileService.writeStudents(Arrays.stream(students).filter(s -> s.getCourse().contains("STAT")).toArray(Student[]::new), "course2.csv");
        FileService.writeStudents(Arrays.stream(students).filter(s -> s.getCourse().contains("APMTH")).toArray(Student[]::new), "course3.csv");
    }
}

