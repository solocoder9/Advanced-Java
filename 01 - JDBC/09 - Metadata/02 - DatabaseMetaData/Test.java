import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = con.getMetaData();
            
            // Retrieve and print database product information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("JDBC Driver Name: " + metaData.getDriverName());
            System.out.println("JDBC Driver Version: " + metaData.getDriverVersion());
            
            // Additional metadata queries can be added here
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
