package com.coderscampus.array4;

import java.io.*;
import java.util.Arrays;


class FileService {
    static Student[] readStudents(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Student[] students = new Student[100]; // assuming there are exactly 100 students
            String line;
            int index = 0;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip reading the first line to avoid NumberFormatException
                }
                String[] data = line.split(",");
                if (data.length != 4) {
                    System.err.println("Malformed data: " + line);
                    continue; // Skip this line and proceed to the next one
                }
                Student student = new Student();
                try {
                    student.setId(String.valueOf(Integer.parseInt(data[0].trim())));
                    student.setName(data[1].trim());
                    student.setCourse(data[2].trim());
                    student.setGrade(Integer.parseInt(data[3].trim()));
                    return new Student[]{new Student(student.id, student.name, student.course, student.grade)};
                } catch (NumberFormatException e) {
                    System.err.println("Invalid grade format: " + data[3]);
                    // Handle this case (e.g., set a default grade or skip the student)
                    // For now, let's set a default grade of 0:
                    student.setGrade(0);
                }
            }
            return students;
        }
    }

    static void writeStudents(Student[] students, String filename)  {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String header = "Student ID, Student Name, Course, Grade";
                writer.write(header);
                writer.newLine();

            for (Student student : students) {
                if (student == null)
                    break;
                String studentLine = student.id + "," + student.name + "," + student.course + "," + student.grade;
                // Debugging output: Print each student line
                System.out.println("Writing student: " + studentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
