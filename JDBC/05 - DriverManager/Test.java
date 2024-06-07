import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";
		
		try {
			// Establish connection
			Connection con = DriverManager.getConnection(url, username, password);

			if (con != null) {
				System.out.println("Connected to the database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
