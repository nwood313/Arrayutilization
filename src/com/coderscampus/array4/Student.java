package com.coderscampus.array4;

class Student {
    String id;
    String name;
    String course;
    Integer grade;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Student(String id, String name, String course, Integer grade){
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Integer getGrade() {
        return grade;
    }
}

