package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateData {
    public static void main(String[] args) {
        // Setup Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        // Open Session
        try (SessionFactory factory = cfg.buildSessionFactory(); 
             Session session = factory.openSession()) {
             
            Transaction tx = session.beginTransaction();
            
            // HQL Update query to update salary
            String hql = "UPDATE Employee SET salary = :salary WHERE eName = 'Suv'";
            Query<?> query = session.createQuery(hql);
            query.setParameter("salary", 99000.00);
            
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            
            tx.commit();
        }
    }
}
