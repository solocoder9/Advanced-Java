import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";

        // Example stored procedure call: CALL getEmployeeDetails(?, ?, ?)
        // This procedure takes one input (employee ID) and returns two outputs (name and salary)
        String procedureCall = "{call getEmployeeDetails(?, ?, ?)}";

        // Use try-with-resources to ensure automatic resource management
        try (Connection con = DriverManager.getConnection(url, username, password);
             CallableStatement cstmt = con.prepareCall(procedureCall)) {
            
            System.out.println("Connection established successfully!");

            // Setting the input parameter (employee ID)
            cstmt.setInt(1, 101);  // Assuming employee ID is 101
            
            // Registering the output parameters
            cstmt.registerOutParameter(2, Types.VARCHAR); // Name is a VARCHAR
            cstmt.registerOutParameter(3, Types.DOUBLE);  // Salary is a DOUBLE
            
            // Execute the stored procedure
            cstmt.execute();

            // Retrieve and print the output parameters
            String name = cstmt.getString(2);
            double salary = cstmt.getDouble(3);

            System.out.println("Employee Name: " + name);
            System.out.println("Employee Salary: " + salary);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
