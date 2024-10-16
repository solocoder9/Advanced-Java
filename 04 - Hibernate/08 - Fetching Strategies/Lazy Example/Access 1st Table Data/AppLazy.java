package com.map2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class AppLazy {
	public static void main(String[] args) {
		// Configure Hibernate
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Open session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Fetch the Category lazily (products will not be fetched until accessed)
		Category category = session.get(Category.class, 1); // Category ID is 1

		// Output the category name
		System.out.println("Category ID: " + category.getCategoryId());
		System.out.println("Category Name: " + category.getCategoryName());

		// Commit transaction
		tx.commit();

		// Close session
		session.close();
		factory.close();
	}
}
