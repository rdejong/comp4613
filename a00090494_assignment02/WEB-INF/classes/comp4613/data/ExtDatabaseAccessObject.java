/** BCIT COMP 4613 Assignment One
 * October 2013
 * @author Rodney deJong
 * A00090494
 */

package comp4613.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullwinkle.dao.DatabaseAccessObject;

/**
 * This class extends the DatabaseAccessObject by adding custom methods 
 * 
 * 
 */

public class ExtDatabaseAccessObject extends DatabaseAccessObject {

	DataBasePropertiesBean dbProp = null;

	/**
	 * Constructor
	 */
	public ExtDatabaseAccessObject(DataBasePropertiesBean dbProp) {
		super();

		this.dbProp = dbProp;
	}

	


	/**
	 * getStatement
	 * 
	 * @return Statement Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Statement returnStmnt() throws ClassNotFoundException, SQLException {
		
		this.loadDatabaseDriver(dbProp.getDriver());
		
		this.connect(dbProp.getUrl(), dbProp.getUser(), dbProp.getPass());

		Connection conn = this.getConnection();
		
		Statement stmnt = conn.createStatement();
		
		System.out.println("Connecting to database");

		return stmnt;

	}

	/**
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * 
	 * @return rsmdList the resultset metadata objects in a vector list
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<String> rowNamesArray(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException {

		ArrayList<String> oneRow = new ArrayList<String>();
		ArrayList allRows = new ArrayList();
		String selectQuery = "SELECT * from a00090494_customers;";
		
		this.loadDatabaseDriver(dbProp.getDriver());

		this.connect(dbProp.getUrl(), dbProp.getUser(), dbProp.getPass());
		
		this.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		
		ResultSet results = this.generateResultSet(selectQuery);
		
		ResultSetMetaData rsmd = this.getResultSetMetadata(results);
		
		while (results.next()) {

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				oneRow.add(results.getString(i));
			}
			
			allRows.add(oneRow);
		}
		

		if (this.getConnection() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return allRows;

	}
	
	/**
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * 
	 * @return rsmdList the resultset metadata objects in an array list
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<String> columnNamesArray(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException {

		String SELECT_STRING = "SELECT * FROM a00090494_customers;";

		this.loadDatabaseDriver(dbProp.getDriver());

		this.connect(dbProp.getUrl(), dbProp.getUser(), dbProp.getPass());
		
		this.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		
		ResultSet results = this.generateResultSet(SELECT_STRING);
		
		ResultSetMetaData rsmd = this.getResultSetMetadata(results);
		
		ArrayList<String> columnNames = new ArrayList<String>();

		// The column count starts from 1
		for (int i = 0; i < rsmd.getColumnCount(); i++) {

			columnNames.add(rsmd.getColumnName(i + 1));
		}

		if (this.getConnection() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return columnNames;

	}

	
	/**
	 * 
	 * @param url
	 *            the url used for database connection
	 * @param user
	 *            the user name for database
	 * @param pass
	 *            the password for database
	 * @param HttpServletResponse
	 *            the Servlet Response
	 * @param driver
	 *            the database driver
	 * 
	 * @return the complete table as resultset objects in a vector list
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public Vector<AddressBookBeanImpl> rsListSelectAll(
			HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {

		Vector<AddressBookBeanImpl> customerList = new Vector<AddressBookBeanImpl>();
		String selectQuery = "Select * from ";
		String tableName = "a00090494_customers";

		this.loadDatabaseDriver(dbProp.getDriver());

		this.connect(dbProp.getUrl(), dbProp.getUser(), dbProp.getPass());

		this.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = this.generateResultSet(selectQuery + tableName);

		while (rs.next()) {

			AddressBookBeanImpl customerBean = new AddressBookBeanImpl();

			customerBean.setMemberId(rs.getInt("memberid"));

			customerBean.setLastName(rs.getString("lastname"));

			customerBean.setFirstName(rs.getString("firstname"));

			customerBean.setAddress(rs.getString("address"));

			customerBean.setCity(rs.getString("city"));

			customerBean.setCode(rs.getString("code"));

			customerBean.setCountry(rs.getString("country"));

			customerBean.setPhone(rs.getString("phone"));

			customerBean.setEmail(rs.getString("email"));

			customerList.add(customerBean);

			System.out.println(" customerBean added to List");
		}

		if (this.getConnection() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return customerList;

	}


	/**
	 * @param url
	 *            the url used for database connection
	 * @param user
	 *            the user name for database
	 * @param pass
	 *            the password for database
	 * @param HttpServletResponse
	 *            the Servlet Response
	 * @param driver
	 *            the database driver
	 * 
	 * @return custom the resultset objects in a vector list
	 * 
	 */
	public AddressBookBeanImpl retrieveCustomerBean(int customerId)
			throws ClassNotFoundException, SQLException {

		String selectQuery = "SELECT * from a00090494_customers WHERE memberId = ";

		AddressBookBeanImpl customerBean = new AddressBookBeanImpl();

		this.loadDatabaseDriver(dbProp.getDriver());

		this.connect(dbProp.getUrl(), dbProp.getUser(), dbProp.getPass());

		this.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = this.generateResultSet(selectQuery + customerId);

		while (rs.next()) {

			customerBean.setMemberId(rs.getInt("memberid"));
			System.out.println(customerBean.getMemberId());
			customerBean.setLastName(rs.getString("lastname"));
			System.out.println(customerBean.getLastName());
			customerBean.setFirstName(rs.getString("firstname"));
			customerBean.setAddress(rs.getString("address"));
			customerBean.setCity(rs.getString("city"));
			customerBean.setCode(rs.getString("code"));
			customerBean.setCountry(rs.getString("country"));
			customerBean.setPhone(rs.getString("phone"));
			customerBean.setEmail(rs.getString("email"));

			System.out.println("customerBean retrieved");

		}

		if (this.getConnection() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return customerBean;
	}

	public boolean addCustomer(AddressBookBeanImpl customerBean)
			throws SQLException, ClassNotFoundException {

		boolean flag = false;

		// String sql1 = ("SET IDENTITY_INSERT a00090494_customers ON");
		// String sql2 = ("SET IDENTITY_INSERT a00090494_customers OFF");

		String v1 = customerBean.getLastName();
		System.out.println(v1);
		String v2 = customerBean.getFirstName();
		System.out.println(v2);
		String v3 = customerBean.getAddress();
		System.out.println(v3);
		String v4 = customerBean.getCity();
		System.out.println(v4);
		String v5 = customerBean.getCode();
		System.out.println(v5);
		String v6 = customerBean.getCountry();
		System.out.println(v6);
		String v7 = customerBean.getPhone();
		System.out.println(v7);
		String v8 = customerBean.getEmail();
		System.out.println(v8);

		String insertSql = "INSERT INTO a00090494_customers(LastName,FirstName,Address,City,Code,Country ,phone,Email )VALUES("
				+ "\'"
				+ v1
				+ "\'"
				+ ","
				+ "\'"
				+ v2
				+ "\'"
				+ ","
				+ "\'"
				+ v3
				+ "\'"
				+ ","
				+ "\'"
				+ v4
				+ "\'"
				+ ","
				+ "\'"
				+ v5
				+ "\'"
				+ ","
				+ "\'"
				+ v6
				+ "\'"
				+ ","
				+ "\'"
				+ v7
				+ "\'"
				+ ","
				+ "\'"
				+ v8
				+ "\'"
				+ ")";

		Statement stmnt = returnStmnt();

		stmnt.execute(insertSql);

		if (stmnt.getUpdateCount() > 0) {

			flag = true;

		} else {

			flag = false;
		}

		if (this.getStatement() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return flag;
	}

	public boolean updateCustomer(AddressBookBeanImpl customerBean)
			throws SQLException, ClassNotFoundException {

		boolean flag = false;
		int memberId = customerBean.getMemberId();

		// String sql1 = ("SET IDENTITY_INSERT a00090494_customers ON");
		// String sql2 = ("SET IDENTITY_INSERT a00090494_customers OFF");
		System.out.println("attempting to update customer: " + memberId);

		String v1 = customerBean.getLastName();
		System.out.println(v1);
		String v2 = customerBean.getFirstName();
		System.out.println(v2);
		String v3 = customerBean.getAddress();
		System.out.println(v3);
		String v4 = customerBean.getCity();
		System.out.println(v4);
		String v5 = customerBean.getCode();
		System.out.println(v5);
		String v6 = customerBean.getCountry();
		System.out.println(v6);
		String v7 = customerBean.getPhone();
		System.out.println(v7);
		String v8 = customerBean.getEmail();
		System.out.println(v8);

		String updateSql = "UPDATE a00090494_customers SET LastName = " + "\'"
				+ v1 + "\'" + "," + "FirstName = " + "\'" + v2 + "\'" + ","
				+ "Address = " + "\'" + v3 + "\'" + "," + "City= " + "\'" + v4
				+ "\'" + "," + "code = " + "\'" + v5 + "\'" + ","
				+ "Country = " + "\'" + v6 + "\'" + "," + "phone = " + "\'"
				+ v7 + "\'" + "," + "Email =" + "\'" + v8 + "\' "
				+ "WHERE memberId = " + "\'" + memberId + "\'";

		Statement stmnt = returnStmnt();

		stmnt.execute(updateSql);

		if (stmnt.getUpdateCount() > 0) {

			flag = true;

		} else {

			flag = false;

		}
		if (this.getStatement() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return flag;
	}

	public boolean deleteCustomer(int memberId) throws SQLException,
			ClassNotFoundException {

		boolean flag = false;
		
		String sqlDeleteStatement = "DELETE from a00090494_customers where memberId = ";
	
		Statement stmnt = returnStmnt();
		
		stmnt.execute(sqlDeleteStatement + memberId);

		if (stmnt.getUpdateCount() > 0) {

			flag = true;

		} else {

			flag = false;
		}

		if (this.getStatement() != null)
			this.closeStatement();

		if (this.getResultSet() != null)
			this.closeResultSet();

		if (this.getConnection() != null)
			this.closeConnection();

		return flag;
	}
}
