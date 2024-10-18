package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {

        // Load configuration and build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction(); // Begin transaction

            // Fetch employee with empID 1
            Employee emp1 = session.get(Employee.class, 1);
            System.out.println("First time fetch: " + emp1);

            // Fetch the same employee again (no database hit, as it’s cached in the first-level cache)
            Employee emp2 = session.get(Employee.class, 1);
            System.out.println("Second time fetch (from first-level cache): " + emp2);

            tx.commit(); // Commit transaction
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        } finally {
            factory.close(); // Close factory
        }
    }
}


/*
+--------+-------+------------+-------+---------+
| deptno | empid | hire_date  | sal   | ename   |
+--------+-------+------------+-------+---------+
|     15 |     1 | 2024-10-09 | 99000 | Suv     |
|     10 |     2 | 2024-10-09 | 75000 | Dev     |
|     20 |     3 | 2024-10-09 | 80000 | Justin  |
|     15 |     4 | 2024-10-09 | 55000 | Charlie |
+--------+-------+------------+-------+---------+
*/
