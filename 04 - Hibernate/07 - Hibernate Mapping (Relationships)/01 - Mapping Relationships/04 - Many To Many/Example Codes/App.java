package com.map3;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Create session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create Students
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setStudentName("John");

        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setStudentName("Emma");

        // Create Courses
        Course course1 = new Course();
        course1.setCourseId(101);
        course1.setCourseName("Mathematics");

        Course course2 = new Course();
        course2.setCourseId(102);
        course2.setCourseName("Science");

        // Associate students with courses (Many-to-Many relationship)
        List<Student> studentsForMath = new ArrayList<>();
        studentsForMath.add(student1);
        studentsForMath.add(student2);

        List<Student> studentsForScience = new ArrayList<>();
        studentsForScience.add(student1);

        course1.setStudents(studentsForMath);
        course2.setStudents(studentsForScience);

        // Associate courses with students
        List<Course> coursesForJohn = new ArrayList<>();
        coursesForJohn.add(course1);
        coursesForJohn.add(course2);

        List<Course> coursesForEmma = new ArrayList<>();
        coursesForEmma.add(course1);

        student1.setCourses(coursesForJohn);
        student2.setCourses(coursesForEmma);

        // Save the students and courses manually
        session.save(student1);
        session.save(student2);
        session.save(course1);
        session.save(course2);

        // Commit transaction
        tx.commit();

        // Retrieve the data back from the database
        List<Course> courses = session.createQuery("from Course", Course.class).list();
        for (Course course : courses) {
            System.out.println(course);
            for (Student student : course.getStudents()) {
                System.out.println(student);
            }
        }

        // Close session and factory
        session.close();
        factory.close();
    }
}
