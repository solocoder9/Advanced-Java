package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {
    public static void main(String[] args) {
        // Create configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Use try-with-resources for session factory
        try (SessionFactory factory = cfg.buildSessionFactory(); 
             Session session = factory.openSession()) {

            // Retrieve employee with empID = 1
            Employee emp = session.get(Employee.class, 1);
            if (emp != null) {
                System.out.println("Employee Details: " + emp);
            } else {
                System.out.println("Employee not found!");
            }
        }
    }
}
