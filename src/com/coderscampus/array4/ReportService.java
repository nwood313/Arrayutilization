package com.coderscampus.array4;


public class ReportService {
    private final StudentService studentService;

    public ReportService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void generateReport(String courseKey, String reportFilename) {
        Student[] studentsOfCourse = studentService.filterStudentsByCourse(courseKey);

        FileService.writeStudents(studentsOfCourse, reportFilename);

    }

}
