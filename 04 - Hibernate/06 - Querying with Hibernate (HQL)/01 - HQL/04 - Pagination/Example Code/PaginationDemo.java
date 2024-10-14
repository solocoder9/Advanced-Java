package com.demo.DemoApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PaginationDemo {
	public static void main(String[] args) {

		// Setup Configuration
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		// Open session
		try (SessionFactory factory = cfg.buildSessionFactory(); Session session = factory.openSession()) {

			Transaction tx = session.beginTransaction();

			// HQL Query to fetch Employee records
			String hql = "FROM Employee"; // Fetch all Employee records
			Query query = session.createQuery(hql);

			// Setting the first result (offset) and the maximum number of results (page size)
			query.setFirstResult(1); // Starting index of the first result(index starts from 0)
			query.setMaxResults(3); // Maximum number of results per page

			// Execute the query and get results
			List<Employee> employees = query.list();

			// Display the employee records from the current page
			for (Employee employee : employees) {
				System.out.println(employee);
			}

			tx.commit(); // Commit transaction
		}
	}
}


/*
+--------+-------+------------+-------+---------+
| deptno | empid | hire_date  | sal   | ename   |
+--------+-------+------------+-------+---------+
|     15 |     1 | 2024-10-09 | 99000 | Suv     |
|     10 |     2 | 2024-10-09 | 75000 | Dev     |
|     20 |     3 | 2024-10-09 | 80000 | Justin  |
|     15 |     4 | 2024-10-09 | 55000 | Charlie |
+--------+-------+------------+-------+---------+

Output:-
empid: 2, ename: Dev, sal: 75000.0, deptno: 10, hire_date: 2024-10-09
empid: 3, ename: Justin, sal: 80000.0, deptno: 20, hire_date: 2024-10-09
empid: 4, ename: Charlie, sal: 55000.0, deptno: 15, hire_date: 2024-10-09
*/
