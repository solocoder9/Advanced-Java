package com.map2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinDemo {
	public static void main(String[] args) {
		
		// Setup Configuration
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		// Open session
		try (SessionFactory factory = cfg.buildSessionFactory();
			 Session session = factory.openSession()) {
			
			Transaction tx = session.beginTransaction();
			
			// HQL Join Query to get category name and product name
            String hql = "SELECT c.categoryName, p.productName FROM Category c INNER JOIN c.products p";
            Query<Object[]> query = session.createQuery(hql);

            // Execute query and fetch results
            List<Object[]> result = query.list();

            // Print the result
            for (Object[] row : result) {
                System.out.println("Category Name: " + row[0] + ", Product Name: " + row[1]);
            }

            tx.commit(); // Commit transaction
		}
	}
}
