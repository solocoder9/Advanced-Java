package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {

		// Create Configuration
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		// Use try-with-resources for automatic session and factory management
		try (SessionFactory factory = cfg.buildSessionFactory(); 
			 Session session = factory.openSession()) {

			// Begin Transaction
			Transaction tx = session.beginTransaction();

			// Create Student object
			Student student1 = new Student();
			student1.setId(1);
			student1.setName("Arijit Singh");
			student1.setCity("Mumbai");

			// Create Certificate object
			Certificate certificate1 = new Certificate();
			certificate1.setCourse("DevOps");
			certificate1.setDuration("4 Months");
			student1.setCerti(certificate1);

			// Create Student object2
			Student student2 = new Student();
			student2.setId(2);
			student2.setName("Armaan Malik");
			student2.setCity("Delhi");

			// Create Certificate object2
			Certificate certificate2 = new Certificate();
			certificate2.setCourse("Java Full Stack");
			certificate2.setDuration("6 Months");
			student1.setCerti(certificate2);

			// Save objects
			session.save(student1);
			session.save(student2);

			// Commit the transaction
			tx.commit();
		}
	}
}
