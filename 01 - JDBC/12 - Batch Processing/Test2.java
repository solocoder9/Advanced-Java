import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "solo";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successful!!!");

            con.setAutoCommit(false); // for manual commit

            String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Job Title: ");
                String job_title = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();

                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, job_title);
                pstmt.setDouble(4, salary);
                sc.nextLine();

                pstmt.addBatch();

                System.out.println("Add more values Y/N: ");
                String decision = sc.nextLine();

                if (decision.toUpperCase().equals("N")) {
                    break;
                }
            }

            // int[] batchResult = pstmt.executeBatch();
            pstmt.executeBatch();
            con.commit();
            System.out.println("Batch Execute Successfully!!!");

            sc.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
