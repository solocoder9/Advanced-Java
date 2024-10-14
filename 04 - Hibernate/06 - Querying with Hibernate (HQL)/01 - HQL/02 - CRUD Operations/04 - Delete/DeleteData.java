package com.demo.DemoApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteData {
	public static void main(String[] args) {
		
		// Setup Configuration
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		// Open session
		try (SessionFactory factory = cfg.buildSessionFactory();
			 Session session = factory.openSession()) {
			
			Transaction tx = session.beginTransaction();
			
			// HQL Delete query to remove an employee
            String hql = "DELETE FROM Employee WHERE eName = :ename";
            Query<?> query = session.createQuery(hql);
            query.setParameter("ename", "Scott");

            int result = query.executeUpdate(); // Execute delete
            System.out.println("Rows deleted: " + result);

            tx.commit(); // Commit transaction
		}
	}
}
