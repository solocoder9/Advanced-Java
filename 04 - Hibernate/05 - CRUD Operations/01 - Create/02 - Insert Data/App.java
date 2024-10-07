package com.demo.DemoApp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		// Create configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create first Employee object
		Employee emp1 = new Employee();
		emp1.seteName("Suv");
		emp1.setDeptNo(15);
		emp1.setHireDate(new Date());
		emp1.setSalary(90000.00);

		// Create second Employee object
		Employee emp2 = new Employee();
		emp2.seteName("Dev");
		emp2.setDeptNo(10);
		emp2.setHireDate(new Date());
		emp2.setSalary(75000.00);

		// Create session
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction(); // Begin transaction

			// Save employee objects
			session.save(emp1); // Save first employee
			session.save(emp2); // Save second employee

			tx.commit(); // Commit transaction
		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace for debugging
		} finally {
			factory.close(); // Close the factory
		}

		System.out.print("Done");
	}
}
