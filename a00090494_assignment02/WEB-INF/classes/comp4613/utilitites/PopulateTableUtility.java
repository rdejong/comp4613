package comp4613.utilitites;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateTableUtility {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://Beangrinder.bcit.ca";

	// Database credentials
	static final String USER = "javastudent";
	static final String PASS = "compjava";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Inserting Row..");
			stmt = conn.createStatement();
		
			String sql2 = "SET IDENTITY_INSERT *.a00090494_customers ON";
			
				//String sql = "SELECT * FROM A00090494_Members";
			// String sql =" INSERT INTO A00090494_Members(Member_Id,LastName, FirstName)VALUES ('1001','Smith', 'Georgia')";
			 String sql = "INSERT INTO a00090494_customers(LastName,FirstName,Address,City,Code ,Country ,phone,Email )VALUES('Berthelet','Eric','1005-Beach Ave','Vancouver','V6G4R4','Canada','604-555-1212','mail@help.com')";
			stmt.executeUpdate(sql);
			System.out.println("Database row inserted successfully...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample

