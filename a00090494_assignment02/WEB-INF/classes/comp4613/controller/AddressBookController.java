/** BCIT COMP 4613 Assignment One
 * October 2013
 * Rodney deJong
 * A00090494
 */
package comp4613.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullwinkle.dao.DatabaseAccessObject;

import comp4613.data.AddressBookBeanImpl;
import comp4613.data.DataBasePropertiesBean;
import comp4613.data.ExtDatabaseAccessObject;
import comp4613.utilitites.UserInputProcessorUtilities;

import org.apache.commons.lang3.*;

/**
 * Servlet implementation class AddressBookController
 */
@WebServlet(description = "main controller for the Address Book System", urlPatterns = { "/member" })
public class AddressBookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DataBasePropertiesBean dbProps = new DataBasePropertiesBean();

	public void init(ServletConfig config) {

		try {

			super.init(config);

		} catch (ServletException e) {

			e.printStackTrace();
		}

		ServletContext context = config.getServletContext();

		dbProps.setDriver(context.getInitParameter("driver"));
		System.out.println("The driver: " + dbProps.getDriver());

		dbProps.setUrl(context.getInitParameter("url"));
		System.out.println("The url: " + dbProps.getUrl());

		dbProps.setUser(context.getInitParameter("user"));
		System.out.println("The user: " + dbProps.getUser());

		dbProps.setPass(context.getInitParameter("pass"));
		System.out.println("The pass: " + dbProps.getPass());

	}

	/*
	 * createCookie - creates a cookie to be set
	 */

	public Cookie createCookie(String key, String value) {
		Cookie c = new Cookie(key, value);
		c.setMaxAge(60 * 60 * 24 * 7); // one week
		return c;
	}

	/*
	 * deleteCustomer - deletes a customer from database
	 */
	public boolean deleteCustomer(int customerId) throws SQLException,
			ClassNotFoundException {

		System.out.println("initializing deleteCustomer method");

		boolean isDeleted = new ExtDatabaseAccessObject(dbProps)
				.deleteCustomer(customerId);

		return isDeleted;
	}

	/*
	 * addCustomer - adds a customer to database
	 */
	public boolean addCustomer(AddressBookBeanImpl customerBean) {

		System.out.println("initializing addCustomer method");

		boolean isAdded = false;

		try {

			isAdded = new ExtDatabaseAccessObject(dbProps)
					.addCustomer(customerBean);

		} catch (SQLException e) {

			System.err.println(e);

		} catch (ClassNotFoundException e) {

			System.err.println(e);
		}

		return isAdded;
	}

	/*
	 * modifyCustomer - modifies customer information in database
	 */
	public boolean modifyCustomer(AddressBookBeanImpl modifyCustomerBean)
			throws SQLException, ClassNotFoundException {

		System.out.println("initializing modifyCustomer method");

		boolean isModified = new ExtDatabaseAccessObject(dbProps)
				.updateCustomer(modifyCustomerBean);

		return isModified;
	}

	/*
	 * getCustomer - gets a customer from database
	 */
	public AddressBookBeanImpl getCustomerBean(int customerId) {

		AddressBookBeanImpl customerBean = null;

		System.out.println("initializing getCustomer method");

		try {

			customerBean = new ExtDatabaseAccessObject(dbProps)
					.retrieveCustomerBean(customerId);

		} catch (ClassNotFoundException e) {

			System.err.println(e);

		} catch (SQLException e) {

			System.err.println(e);

		}

		return customerBean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String chooseAction = request.getParameter("formId");

		if (chooseAction.equalsIgnoreCase("verifyCustomerDelete")) {

			System.out.println("FormId: " + chooseAction);

			AddressBookBeanImpl retrieveVerifyCustomerBean = null;
			String customerUid = "memberId";
			int dValue = -1;

			int id = UserInputProcessorUtilities.getIntParameter(request,
					customerUid, dValue);

			retrieveVerifyCustomerBean = getCustomerBean(id);

			System.out.println("retrieved member id: " + id);

			HttpSession session = request.getSession();

			session.setAttribute("confirmDelete", retrieveVerifyCustomerBean);

			request.getRequestDispatcher(
					"/WEB-INF/jsp/verifyCustomerDelete.jsp").forward(request,
					response);
		}

		else if (chooseAction.equalsIgnoreCase("start")) {

			System.out.println("FormId: " + chooseAction);

			ResultSetMetaData rsmd = null;

			ResultSet results = null;

			HttpSession session = request.getSession();

			String selectQuery = "SELECT * FROM a00090494_customers";

			System.out.println(selectQuery);

			session.setAttribute("currentQuery", selectQuery);

			DatabaseAccessObject dao = new DatabaseAccessObject();

			try {

				dao.loadDatabaseDriver(dbProps.getDriver());

				dao.connect(dbProps.getUrl(), dbProps.getUser(),
						dbProps.getPass());

				dao.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_READ_ONLY);

				results = dao.generateResultSet(selectQuery);

				rsmd = dao.getResultSetMetadata(results);

			} catch (SQLException | ClassNotFoundException e) {
				response.sendError(400,
						"The dad-burned thing blew up because of something YOU did.");
			}

			@SuppressWarnings("rawtypes")
			ArrayList allRows = new ArrayList();
			ArrayList<String> columnNames = new ArrayList<String>();

			try {

				for (int i = 0; i < rsmd.getColumnCount(); i++) {

					columnNames.add(rsmd.getColumnName(i + 1));
				}

				while (results.next()) {

					ArrayList<String> oneRow = new ArrayList<String>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						oneRow.add(results.getString(i));
					}
					allRows.add(oneRow);
				}
			} catch (SQLException e) {
				response.sendError(500, "Unable top read data.");
			}

			synchronized (session) {

				session.setAttribute("arrayListAllRows", allRows);

				session.setAttribute("arryListColumnNames", columnNames);

				request.getRequestDispatcher("/WEB-INF/jsp/start.jsp").include(
						request, response);
			}
		}

		else if (chooseAction.equalsIgnoreCase("selectColumnsStart")) {

			System.out.println("FormId: " + chooseAction);

			Enumeration paramNames = request.getParameterNames();

			String[] paramValues = null;
			String joined = null;

			while (paramNames.hasMoreElements()) {

				String paramName = (String) paramNames.nextElement();

				if (paramName.equalsIgnoreCase("column")) {

					paramValues = request.getParameterValues(paramName);

					if (paramValues.length > 0) {

						joined = StringUtils.join(paramValues, ",");

						System.out.println("There are: " + paramValues.length

						+ " columns in the string array -");

						System.out.println(joined);

						for (int i = 0; i < paramValues.length; i++) {

							System.out.println(paramValues[i]);
						}

					}
				}
			}

			ResultSetMetaData rsmd = null;

			ResultSet results = null;

			HttpSession session = request.getSession();

			String selectQuery = "SELECT " +joined+ " FROM a00090494_customers";

			System.out.println(selectQuery);

			session.setAttribute("currentQuery", selectQuery);

			DatabaseAccessObject dao = new DatabaseAccessObject();

			try {

				dao.loadDatabaseDriver(dbProps.getDriver());

				dao.connect(dbProps.getUrl(), dbProps.getUser(),
						dbProps.getPass());

				dao.initializeStatement(ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_READ_ONLY);

				results = dao.generateResultSet(selectQuery);

				rsmd = dao.getResultSetMetadata(results);

			} catch (SQLException | ClassNotFoundException e) {
				response.sendError(400,
						"The dad-burned thing blew up because of something YOU did.");
			}

			@SuppressWarnings("rawtypes")
			ArrayList allRows = new ArrayList();
			ArrayList<String> columnNames = new ArrayList<String>();

			try {

				for (int i = 0; i < rsmd.getColumnCount(); i++) {

					columnNames.add(rsmd.getColumnName(i + 1));
				}

				while (results.next()) {

					ArrayList<String> oneRow = new ArrayList<String>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						oneRow.add(results.getString(i));
					}
					allRows.add(oneRow);
				}
			} catch (SQLException e) {
				response.sendError(500, "Unable top read data.");
			}

			synchronized (session) {

				session.setAttribute("arrayListAllRows", allRows);

				session.setAttribute("arryListColumnNames", columnNames);

				session.setAttribute("custSelectCol", paramValues);

				session.setAttribute("selectString", joined);

				request.getRequestDispatcher(

				"/WEB-INF/jsp/selectColumnsStart.jsp").include(request,
						response);
			}

		} else if (chooseAction.equalsIgnoreCase("addCustomer")) {

			System.out.println("FormId: " + chooseAction);

			request.getRequestDispatcher("/WEB-INF/jsp/addCustomerForm.jsp")
					.include(request, response);
		}

		else if (chooseAction.equalsIgnoreCase("searchCustomer")) {

			System.out.println("FormId: " + chooseAction);

			request.getRequestDispatcher("/WEB-INF/jsp/searchCustomerForm.jsp")
					.include(request, response);

		} else if (chooseAction.equalsIgnoreCase("retrieveCustomerBean")) {

			System.out.println("FormId: " + chooseAction);

			AddressBookBeanImpl retrieveCustomerBean = null;
			String customerUid = "memberId";
			int dValue = -1;

			int id = UserInputProcessorUtilities.getIntParameter(request,
					customerUid, dValue);

			System.out.println("Retrieving member id: " + id);

			try {

				retrieveCustomerBean = new ExtDatabaseAccessObject(dbProps)
						.retrieveCustomerBean(id);

			} catch (ClassNotFoundException e) {

				System.err.println(e);

			} catch (SQLException e) {

				System.err.println(e);

			}

			if (retrieveCustomerBean.getMemberId() > 0) {

				System.out.println("Found customer with Id: "
						+ retrieveCustomerBean.getMemberId());

				HttpSession session = request.getSession();

				synchronized (session) {

					session.setAttribute("customerBean", retrieveCustomerBean);

					request.getRequestDispatcher(
							"/WEB-INF/jsp/modifyCustomerForm.jsp").forward(
							request, response);
				}

			} else {

				System.out
						.println("Customer not found with id: " + customerUid);

				request.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp")
						.forward(request, response);
			}
		} else if (chooseAction.equalsIgnoreCase("deleteCustomer")) {

			System.out.println("Form Id is equal: " + chooseAction);
			String customerUid = "customerId";
			int dValue = -1;

			int id = UserInputProcessorUtilities.getIntParameter(request,
					customerUid, dValue);

			try {

				if (deleteCustomer(id)) {

					System.out.println("customer id : " + id
							+ " has been deleted");

					request.getRequestDispatcher("/WEB-INF/jsp/start.jsp")
							.forward(request, response);
				} else {

					System.out.println("Unable to delete customer id: " + id);

					request.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp")
							.include(request, response);
				}
			} catch (SQLException e) {

				System.err.println(e);

			} catch (ClassNotFoundException e) {

				System.err.println(e);
			}

		} else {

			System.out.println("Not able to choose action with : "
					+ chooseAction);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String chooseAction = request.getParameter("formId");

		if (chooseAction.equalsIgnoreCase("modifyCustomer")) {

			System.out.println("FormId: " + chooseAction);

			try {

				AddressBookBeanImpl modifyCustomerBean = new AddressBookBeanImpl(
						request);

				String customerUid = "memberId";
				int dValue = -1;
				int id = UserInputProcessorUtilities.getIntParameter(request,
						customerUid, dValue);

				modifyCustomerBean.setMemberId(id);

				boolean isModified = modifyCustomer(modifyCustomerBean);

				if (isModified) {

					System.out.println("Customer updated!");

					HttpSession session = request.getSession();

					synchronized (session) {

						session.setAttribute("customerBean", modifyCustomerBean);

						request.getRequestDispatcher("/WEB-INF/jsp/success.jsp")
								.include(request, response);
					}
				} else {

					System.out.println("Unable to update customer");

				}

			} catch (SQLException e) {

				System.err.println(e);

			} catch (ClassNotFoundException e) {

				System.err.println(e);

			}

		} else if (chooseAction.equalsIgnoreCase("addCustomer")) {

			System.out.println("FormId: " + chooseAction);

			AddressBookBeanImpl customerBean = null;

			try {

				customerBean = new AddressBookBeanImpl(request);

			} catch (SQLException e) {

				System.err.println(e);

			}

			boolean isAdded = addCustomer(customerBean);

			if (isAdded) {

				System.out.println("Customer added to database!");

				Cookie userCookieFirstName = createCookie("fistName",
						customerBean.getFirstName());
				Cookie userCookieLastName = createCookie("lastName",
						customerBean.getLastName());

				response.addCookie(userCookieFirstName);
				response.addCookie(userCookieLastName);

				HttpSession session = request.getSession();

				synchronized (session) {

					session.setAttribute("customerBean", customerBean);

					request.getRequestDispatcher("/WEB-INF/jsp/success.jsp")
							.include(request, response);
				}

			} else {

				System.out.print("Unable to choose action based on input");
			}
		}
	}
}
