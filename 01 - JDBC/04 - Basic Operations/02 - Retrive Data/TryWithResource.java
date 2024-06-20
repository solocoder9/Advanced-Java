import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResource {
    public static void main(String[] args) {
        
        // 1. Load and register the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class for newer MySQL versions
            System.out.println("Driver loaded successfully!!");
        } catch(ClassNotFoundException e) {
            System.out.println("Failed to load the driver: " + e.getMessage());
        }
        
        // 2. Establish the connection and use try-with-resources
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "solo";
        
        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE salary > 70000")
        ) {
            System.out.println("Connection established successfully!!");
            
            // 3. Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                
                System.out.println();
                System.out.println("===================================================\n");
                
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + job_title);
                System.out.println("Salary: " + salary);
            }
            
            System.out.println("Connection closed successfully");
            
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
