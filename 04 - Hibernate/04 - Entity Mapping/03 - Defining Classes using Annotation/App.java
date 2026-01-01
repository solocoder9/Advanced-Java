package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Project started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Create Student object
		// Student st = new Student(id, name, city);
		Student st = new Student();
		st.setId(101);
		st.setName("John");
		st.setCity("Delhi");
		System.out.println(st);
		
		// Create session 
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		
		session.close();
	}
}
