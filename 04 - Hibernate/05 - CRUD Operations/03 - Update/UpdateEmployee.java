package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
    public static void main(String[] args) {
        // Create configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Use try-with-resources for session factory
        try (SessionFactory factory = cfg.buildSessionFactory(); 
             Session session = factory.openSession()) {

            // Start a transaction
            Transaction tx = session.beginTransaction();

            // Retrieve employee with empID = 1
            Employee emp = session.get(Employee.class, 1);
            if (emp != null) {
                emp.setSalary(95000.00); // Update salary
                emp.seteName("Suv Updated"); // Update name
                session.update(emp); // Save changes
            }

            // Commit the transaction
            tx.commit();
            System.out.println("Employee updated successfully!");
        }
    }
}
