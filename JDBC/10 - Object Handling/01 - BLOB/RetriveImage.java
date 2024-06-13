import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetriveImage {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";
		String folder_path = "C:\\Users\\Dell\\Downloads\\Other\\";
		String query = "SELECT image_data from image_table where image_id = (?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully!!");
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1);
			
			ResultSet rt = pstmt.executeQuery();
			
			if (rt.next()) {
				
				byte[] imageData = rt.getBytes("image_data");
				String image_path = folder_path + "ExtractedImage.jpg";
				OutputStream os = new FileOutputStream(image_path);
				os.write(imageData);
				System.out.println("Image retrived successfully!!");
				
				os.close();
				
			} else {
				System.out.println("Image not found");
			}
			
			pstmt.close();
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
