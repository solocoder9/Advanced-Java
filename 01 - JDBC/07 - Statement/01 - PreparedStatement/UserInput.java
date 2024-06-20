import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!!");

            // User input
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the ID:");
            int id = sc.nextInt();

            sc.nextLine(); // consume newline

            System.out.print("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the job title: ");
            String job_title = sc.nextLine();

            System.out.print("Enter the salary: ");
            Double salary = sc.nextDouble();

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, job_title);
            pstmt.setDouble(4, salary);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Inserted Successfully!!!");
            } else {
                System.out.println("Data Insertion Failed!!");
            }

            pstmt.close();
            sc.close();
            con.close();
            System.out.println("Connection closed successfully!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
