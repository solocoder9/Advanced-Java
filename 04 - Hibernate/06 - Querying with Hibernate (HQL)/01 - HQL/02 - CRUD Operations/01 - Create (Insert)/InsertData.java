package com.demo.DemoApp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
	public static void main(String[] args) {

		// Create configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create 1st Employee object
		Employee emp1 = new Employee();
		emp1.seteName("Suv");
		emp1.setDeptNo(15);
		emp1.setHireDate(new Date());
		emp1.setSalary(90000.00);

		// Create 2nd Employee object
		Employee emp2 = new Employee();
		emp2.seteName("Dev");
		emp2.setDeptNo(10);
		emp2.setHireDate(new Date());
		emp2.setSalary(75000.00);

		// Create 3rd Employee object
		Employee emp3 = new Employee();
		emp3.seteName("Justin");
		emp3.setDeptNo(20);
		emp3.setHireDate(new Date());
		emp3.setSalary(80000.00);

		// Create 4th Employee object
		Employee emp4 = new Employee();
		emp4.seteName("Charlie");
		emp4.setDeptNo(15);
		emp4.setHireDate(new Date());
		emp4.setSalary(55000.00);

		// Create 5th Employee object
		Employee emp5 = new Employee();
		emp5.seteName("Scott");
		emp5.setDeptNo(20);
		emp5.setHireDate(new Date());
		emp5.setSalary(72000.00);

		// Create session
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction(); // Begin transaction

			// Save employee objects (Insert)
			session.save(emp1); // Save 1st employee
			session.save(emp2); // Save 2nd employee
			session.save(emp3); // Save 3rd employee
			session.save(emp4); // Save 4th employee
			session.save(emp5); // Save 5th employee

			tx.commit(); // Commit transaction
		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace for debugging
		} finally {
			factory.close(); // Close the factory
		}

		System.out.print("Done");
	}
}
