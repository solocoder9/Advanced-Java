import java.sql.*;

public class RetrieveData {
    public static void main(String[] args) throws ClassNotFoundException {
        
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String query = "SELECT * FROM employees;";
        
        // 1. Load and register the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!!");
        } catch(ClassNotFoundException e) {
            System.out.println("Failed to load the driver: " + e.getMessage());
        }
        
        // 2. Establish the connection
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!!");
            
            // 3. Create a statement
            Statement stmt = con.createStatement();
            
            // 4. Execute the query
            ResultSet rs = stmt.executeQuery(query);
            
            // 5. Process the result set
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
            
            // 6. Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully");
            
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
