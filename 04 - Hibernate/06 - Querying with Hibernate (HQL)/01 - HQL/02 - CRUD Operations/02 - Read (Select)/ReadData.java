package com.demo.DemoApp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadData {
    public static void main(String[] args) {
        // Create configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try (SessionFactory factory = cfg.buildSessionFactory(); 
             Session session = factory.openSession()) {
             
            Transaction tx = session.beginTransaction();
            
            // HQL Select query to fetch all Employees
            String hql = "FROM Employee";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            List<Employee> employees = query.list();
            
            for (Employee e : employees) {
                System.out.println(e);
            }
            
            tx.commit();
        }
    }
}
