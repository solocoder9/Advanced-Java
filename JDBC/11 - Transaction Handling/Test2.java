import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "solo";
		String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
		String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully!!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully!!");

			con.setAutoCommit(false); // set manually commit

			try {
				PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
				PreparedStatement depositStatement = con.prepareStatement(depositQuery);

				withdrawStatement.setDouble(1, 500.00);
				withdrawStatement.setString(2, "account123");

				depositStatement.setDouble(1, 500.00);
				depositStatement.setString(2, "account3536"); // wrong account

				int rowsAffectedWithdrawl = withdrawStatement.executeUpdate();
				int rowsAffectedDeposit = depositStatement.executeUpdate();

				if (rowsAffectedWithdrawl > 0 && rowsAffectedDeposit > 0) {
					con.commit();
					System.out.println("Transaction Successful!!");
				} else {
					con.rollback();
					System.out.println("Transaction Failed!!");
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

/**
 * Output:- 
 * Driver loaded successfully!! 
 * Connection established successfully!!
 * Transaction Failed!!
 */