import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;

public class RetriveDocument {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String querySQL = "SELECT title, content FROM documents WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(querySQL)) {

            // Set the ID parameter to search
            pstmt.setInt(1, 1);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve the title
                    String title = rs.getString("title");
                    System.out.println("Title: " + title);

                    // Retrieve and read the CLOB content
                    try (Reader contentReader = rs.getCharacterStream("content");
                         BufferedReader br = new BufferedReader(contentReader)) {
                        
                        String line;
                        System.out.println("Content:");
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No document found with the specified ID.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
