package com.coderscampus.array4;

import java.io.*;
import java.util.Arrays;


public class FileService {

    public static Student[] readStudents(String filename) throws IOException {
        Student[] students = new Student[100];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;

            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip reading the first line to avoid NumberFormatException
                }
                String[] data = line.split(",");
                //    System.out.println(line); this is a read test; the csv data prints to the console at this line
                if (data.length != 4) {
                    System.err.println("Malformed data: " + line);
                    continue; // Skip this line and proceed to the next one
                }
                try {
                    int studentId = Integer.parseInt(data[0].trim());
                    String studentName = data[1].trim();
                    String course = data[2].trim();
                    int grade = Integer.parseInt(data[3].trim());
                    students[index++] = new Student(studentId, studentName, course, grade);

                } catch (Exception e) {
                    System.err.println("Invalid grade format: " + data[3]);
                    // Handle this case (e.g., set a default grade or skip the student)
                    // For now, let's set a default grade of 0:
                    //student.grade = 0;
                }
            }
        }
        return students;
    }

    public static void writeStudents(Student[] students, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String header = "Student ID, Student Name, Course, Grade";
            writer.write(header);
            writer.newLine();
            System.out.println("Your files have been written successfully arranged by course and then by grade!");
            //System.out.println(Arrays.toString(students)); Test to see if the array contains objects at this point

            for (Student student : students) {
                if (student == null)
                    break;
                String line = student.getStudentId() + "," + student.getStudentName() + "," + student.getCourse() + "," + student.getGrade();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

