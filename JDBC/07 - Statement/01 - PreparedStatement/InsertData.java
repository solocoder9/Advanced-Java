import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";
		String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully!!");

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 4);
			pstmt.setString(2, "Pravat");
			pstmt.setString(3, "DevOps Engineer");
			pstmt.setDouble(4, 85000.00);

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Data Inserted Successfully!!!");
			} else {
				System.out.println("Data Insertion Failed!!");
			}

			pstmt.close();
			con.close();
			System.out.println("Connection closed successfully!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
