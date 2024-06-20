import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImage {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String image_path = "C:\\Users\\Dell\\Downloads\\Other\\Hacker.jpg";
        String query = "INSERT INTO image_table(image_data) VALUES(?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!!");

            FileInputStream fis = new FileInputStream(image_path);
            byte[] imageData = new byte[fis.available()];
            fis.read(imageData);

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setBytes(1, imageData);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Image Inserted Successfully!!");
            } else {
                System.out.println("Image not inserted!!");
            }

            pstmt.close();
            fis.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
