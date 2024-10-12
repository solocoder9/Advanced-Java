package com.map2;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppWithCascading {
	public static void main(String[] args) {

		// Configuration
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Create Products
		Product product1 = new Product();
		product1.setProductId(101);
		product1.setProductName("Phone");

		Product product2 = new Product();
		product2.setProductId(102);
		product2.setProductName("Tablet");

		Product product3 = new Product();
		product3.setProductId(103);
		product3.setProductName("Laptop");

		// Create Category
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Electronic Devices");

		// Associate products with category
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		category.setProducts(products);

		// Associate category with products
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);

		// Save the category; cascading will automatically save associated products
		session.save(category);

		tx.commit();
		session.close();
		factory.close();
	}
}

/*
Changes in Category Entity class
--------------------------------
@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<Product> products;

Explanation:
- With cascading (CascadeType.ALL), when the category is saved, all the associated products 
  will also be saved automatically.
- You only need to save the category, and Hibernate will take care of saving the products 
  due to cascading.
*/
