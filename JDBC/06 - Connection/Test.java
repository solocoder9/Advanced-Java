import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            // Check if connection is valid
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Create a statement and execute a query
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees;");

                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Double salary = resultSet.getDouble("salary");
                    System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
