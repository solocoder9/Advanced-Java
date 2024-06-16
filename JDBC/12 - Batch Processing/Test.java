import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully!!!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successful!!!");

			con.setAutoCommit(false); // for manual commit

			Statement stmt = con.createStatement();
			stmt.addBatch("INSERT INTO employees(id, name, job_title, salary) VALUES(6, 'Vashu', 'HR Manager', 65000.00)");
			stmt.addBatch("INSERT INTO employees(id, name, job_title, salary) VALUES(7, 'Karan', 'Cyber Security', 62000.00)");
			stmt.addBatch("INSERT INTO employees(id, name, job_title, salary) VALUES(8, 'Vipul', 'DevOps Engineer', 67000.00)");

			// int[] batchResult = stmt.executeBatch(); 
			stmt.executeBatch();
			
			con.commit();
			System.out.println("Batch executed successfully!!!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
