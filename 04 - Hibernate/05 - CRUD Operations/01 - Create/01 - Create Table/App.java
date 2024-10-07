package com.demo.DemoApp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	
        // Load configuration and build session factory
    	  /*
    	  Configuration cfg = new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  */
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // The table is created automatically based on entity mappings at this point
        System.out.println("Table 'Employee' has been created in the database!");
        
        // Close session factory
        sessionFactory.close();
    }
}