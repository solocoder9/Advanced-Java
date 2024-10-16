package com.demo.DemoApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NativeSQLDemo {
    public static void main(String[] args) {

        // Setup Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        // Open session
        try (SessionFactory factory = cfg.buildSessionFactory(); 
        	 Session session = factory.openSession()) {

            Transaction tx = session.beginTransaction(); // Begin transaction

            // Create Native SQL query to fetch Employee data from the 'employee' table
            String sql = "SELECT * FROM employee WHERE deptno = :deptNo"; // Native SQL query

            // Create a NativeQuery object
            NativeQuery<Employee> query = session.createNativeQuery(sql, Employee.class);

            // Set a parameter for the query (replacing :deptNo)
            query.setParameter("deptNo", 15);

            // Execute the query and get the result list
            List<Employee> employees = query.getResultList();

            // Display the employee data retrieved by the native query
            for (Employee employee : employees) {
                System.out.println(employee);
            }

            tx.commit(); // Commit transaction
        }
    }
}
