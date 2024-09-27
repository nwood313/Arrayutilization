package com.coderscampus.array4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {
    private final String FILENAME = "student masterlist.csv";
    private Student[] students;

    public StudentService() throws IOException {
        students = FileService.readStudents(FILENAME);
        //sort students by course and grade
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    public Student[] filterStudentsByCourse(String courseKey) {
        return Arrays.stream(students)
        .filter(s -> s.getCourse().contains(courseKey)).toArray(Student[]::new);
    }

}
