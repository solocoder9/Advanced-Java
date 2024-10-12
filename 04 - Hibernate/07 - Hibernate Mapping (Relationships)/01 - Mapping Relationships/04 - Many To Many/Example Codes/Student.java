package com.map3;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private int studentId;
    private String studentName;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student() {
        super();
    }

    public Student(int studentId, String studentName, List<Course> courses) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
    }
}
