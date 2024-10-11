package com.map2;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Create session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create and save Products
        Product product1 = new Product();
        product1.setProductId(101);
        product1.setProductName("Phone");

        Product product2 = new Product();
        product2.setProductId(102);
        product2.setProductName("Tablet");

        Product product3 = new Product();
        product3.setProductId(103);
        product3.setProductName("Laptop");

        // Create Category and associate it with Products
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Electronic Devices");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        // Set category for each product
        product1.setCategory(category);
        product2.setCategory(category);
        product3.setCategory(category);

        // Set products list in the category
        category.setProducts(products);
        
        // Save the products first
        session.save(product1);
        session.save(product2);
        session.save(product3);

        // Save the category 
        session.save(category);
        

        // Commit transaction
        tx.commit();

        // Retrieve the data back from the database
        List<Category> categories = session.createQuery("from Category", Category.class).list();
        for (Category c : categories) {
            System.out.println(c);
            for (Product p : c.getProducts()) {
                System.out.println(p);
            }
        }

        // Close session and factory
        session.close();
        factory.close();
    }
}
