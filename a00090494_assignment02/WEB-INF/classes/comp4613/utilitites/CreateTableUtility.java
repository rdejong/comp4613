package comp4613.utilitites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableUtility {

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
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			String firstSql = ("DROP TABLE a00090494_customers");
			// String sql =
			// "CREATE TABLE A00090494_Members(member_id int NOT NULL PRIMARY KEY,lastname varchar(255) NOT NULL,firstname varchar(255),address varchar(255),city varchar(255),code varchar(255),country varchar(255),phone varchar(255),email varchar(255))";
			String sql = "CREATE TABLE a00090494_customers(memberId int NOT NULL PRIMARY KEY IDENTITY(100,1),lastname varchar(255) NOT NULL,firstname varchar(255),address varchar(255),city varchar(255),code varchar(255),country varchar(255),phone varchar(255),email varchar(255))";
			stmt.executeUpdate(firstSql);
			System.out.println("Database dropped successfully...");
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
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