import java.sql.*;

public class Test {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users");

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();

            System.out.println("Column Details:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + rsMetaData.getColumnName(i));
                System.out.println("Column Type: " + rsMetaData.getColumnTypeName(i));
                System.out.println("Column Size: " + rsMetaData.getColumnDisplaySize(i));
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
