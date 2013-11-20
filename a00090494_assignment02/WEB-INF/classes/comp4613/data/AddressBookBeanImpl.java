/**
 * AddressBookBean
 */
package comp4613.data;

import java.io.Serializable;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Rodney deJong
 */
public class AddressBookBeanImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	private int memberId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String code;
	private String country;
	private String phone;
	private String email;

	/**
	 * no args default constructor
	 * 
	 */
	public AddressBookBeanImpl() {
	}

	/**
	 * creates and sets bean with http request form parameters
	 * 
	 * @param HttpServletRequest
	 * 
	 */
	public AddressBookBeanImpl(HttpServletRequest request) throws SQLException {

		this.setLastName(request.getParameter("lastName"));
		this.setFirstName(request.getParameter("firstName"));
		this.setAddress(request.getParameter("address"));
		this.setCity(request.getParameter("city"));
		this.setCode(request.getParameter("code"));
		this.setCountry(request.getParameter("country"));
		this.setPhone(request.getParameter("phone"));
		this.setEmail(request.getParameter("email"));
	}

	/**
	 * @return the firstName
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param the
	 *            memberId to set
	 */

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
