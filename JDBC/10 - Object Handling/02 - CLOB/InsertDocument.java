import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileReader;
import java.io.IOException;

public class InsertDocument {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String insertSQL = "INSERT INTO documents (id, title, content) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(insertSQL)) {

            // Set ID and title
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Sample Document");

            // Read CLOB data from a file and set it as the content
            try (FileReader reader = new FileReader("large_text_file.txt")) {
                pstmt.setCharacterStream(3, reader);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("CLOB data inserted successfully!");
            } else {
                System.out.println("CLOB data insertion failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
