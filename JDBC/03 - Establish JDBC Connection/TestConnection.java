import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "solo");

            // Print a success message
            System.out.println("Connection established successfully!!!");

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException e) {
            // Print error message if driver class not found
            System.err.println("JDBC Driver not found. Add the MySQL Connector/J JAR to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Print error message if connection fails
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }
}
