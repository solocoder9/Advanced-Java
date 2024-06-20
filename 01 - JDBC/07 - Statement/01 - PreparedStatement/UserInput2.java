// User Input PreparedStatement JDBC program using try-with-resources.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput2 {
    public static void main(String[] args) {

        // Step 1: Define database connection parameters
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String query = "INSERT INTO employees (id, name, job_title, salary) VALUES (?, ?, ?, ?)";

        try {
            // Step 2: Load the MySQL JDBC driver (modern class name)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!!");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load JDBC driver: " + e.getMessage());
            e.printStackTrace();
            return; // Exit the program if the driver is not loaded
        }

        // Step 3: Collect user input
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the job title: ");
            String jobTitle = sc.nextLine();

            System.out.print("Enter the salary: ");
            double salary = sc.nextDouble();

            // Step 4: Establish the connection using try-with-resources
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement pstmt = con.prepareStatement(query)) {
                 
                System.out.println("Connection established successfully!!");

                // Step 5: Set parameters for the prepared statement
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, jobTitle);
                pstmt.setDouble(4, salary);

                // Step 6: Execute the query
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully!!!");
                } else {
                    System.out.println("Data insertion failed!!");
                }
            } catch (SQLException e) {
                System.err.println("SQL error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
