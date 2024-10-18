package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {

        // Load configuration and build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // First session
        try (Session session1 = factory.openSession()) {
            Transaction tx = session1.beginTransaction(); // Begin transaction

            // Fetch employee with empID 1 (will hit the database)
            Employee emp1 = session1.get(Employee.class, 1);
            System.out.println("Session 1 - First fetch: " + emp1);

            tx.commit(); // Commit transaction
        }

        // Second session
        try (Session session2 = factory.openSession()) {
            Transaction tx = session2.beginTransaction(); // Begin transaction

            // Fetch employee with empID 1 (will use the second-level cache)
            Employee emp2 = session2.get(Employee.class, 1);
            System.out.println("Session 2 - Fetch from second-level cache: " + emp2);

            tx.commit(); // Commit transaction
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        } finally {
            factory.close(); // Close factory
        }
    }
}
