package com.coderscampus.array4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read students from the CSV file
    //    Student[] students = FileService.readStudents("student masterlist.csv");
        // Sort students by course and grade

    //    Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());


        StudentService studentService = new StudentService();
        ReportService reportService = new ReportService(studentService);
        reportService.generateReport("COMPSCI", "course1.csv");
        reportService.generateReport("STAT", "course2.csv");
        reportService.generateReport("COMPSCI", "course3.csv");




    }

}
