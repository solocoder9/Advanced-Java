package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        // Create a session
        Session session = factory.openSession();
        
        // Begin transaction
        session.beginTransaction();
        
        // Create a new Department object
        Department department = new Department("HR", "New York");
        
        // Save the department
        session.save(department);
        
        // Commit transaction
        session.getTransaction().commit();
        
        // Close the session
        session.close();
        
        System.out.println("Department inserted successfully.");
    }
}
