package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import java.util.List;

public class BetweenCriteriaDemo {
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

            // Add restriction to fetch employees with salary between 80000 and 90000
            criteria.add(Restrictions.between("salary", 80000.0, 90000.0));

            // Execute query and get the list of results
            List<Employee> employees = criteria.list();

            // Commit transaction
            tx.commit();

            // Display the results using the toString method
            if (!employees.isEmpty()) {
                System.out.println("Employees with salary between 80000 and 90000:");
                for (Employee emp : employees) {
                    System.out.println(emp);
                }
            } else {
                System.out.println("No employees found with a salary between 80000 and 90000");
            }

        } // No explicit catch block
    }
}
