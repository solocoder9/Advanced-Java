package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

public class EqualCriteriaDemo {
    public static void main(String[] args) {
        // Create configuration and build session factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Use try-with-resources for session factory and session
        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {

            // Start transaction
            Transaction tx = session.beginTransaction();

            // Create Criteria object
            Criteria criteria = session.createCriteria(Employee.class);

            // Add restriction to fetch employee where eName is "Suv"
            criteria.add(Restrictions.eq("eName", "Suv"));

            // Execute query and get single result
            Employee emp = (Employee) criteria.uniqueResult();

            // Commit transaction
            tx.commit();

            // Display the result using the toString method
            if (emp != null) {
                System.out.println("Employee Details: " + emp);
            } else {
                System.out.println("No employee found with the name 'Suv'");
            }

        }
    }
}
