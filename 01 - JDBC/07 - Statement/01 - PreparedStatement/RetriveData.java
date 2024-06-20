import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetriveData {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";
		String query = "SELECT * FROM employees WHERE name = ? AND salary = ? ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully!!\n");
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Hemant");
			pstmt.setDouble(2, 65000.00);
			
			ResultSet rt = pstmt.executeQuery();
			
			while (rt.next()) {
				int id = rt.getInt("id");
				String name = rt.getString("name");
				String job_title = rt.getString("job_title");
				Double salary = rt.getDouble("salary");
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Job Title: " + job_title);
				System.out.println("Salary: " + salary);
			}
			
			rt.close();
			pstmt.close();
			con.close();
			System.out.println("Connection closed successfully!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
