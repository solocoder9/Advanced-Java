import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String query = "UPDATE employees "
                + "SET job_title = 'React Developer', salary = 70000.00"
                + "WHERE id = 3;";

        // Load & Register the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Establish the connection
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the query
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Update successful " + rowsAffected + " row(s) affected. ");
            } else {
                System.out.println("Update failed!!");
            }

            // close the connections
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
