package comp4613.utilitites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class UserInputProcessorUtilities {

	public UserInputProcessorUtilities() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Read a parameter with the specified name, convert it to an int, and
	 * return it. Return the designated default value if the parameter doesn't
	 * exist or if it is an illegal integer format.
	 */

	public static int getIntParameter(HttpServletRequest request,
			String paramName, int defaultValue) {
		String paramString = request.getParameter(paramName);
		int paramValue;
		try {
			paramValue = Integer.parseInt(paramString);
		} catch (NumberFormatException nfe) { // null or bad format
			paramValue = defaultValue;
		}
		return (paramValue);
	}
	
	/** Given a string, this method replaces all occurrences of
	   *  '<' with '&lt;', all occurrences of '>' with
	   *  '&gt;', and (to handle cases that occur inside attribute
	   *  values), all occurrences of double quotes with
	   *  '&quot;' and all occurrences of '&' with '&amp;'.
	   *  Without such filtering, an arbitrary string
	   *  could not safely be inserted in a Web page.
	   */

		public static String filter(String input) {
			StringBuffer filtered = new StringBuffer(input.length());
			char c;
			for (int i = 0; i < input.length(); i++) {
				c = input.charAt(i);
				if (c == '<') {
					filtered.append("&lt;");
				} else if (c == '>') {
					filtered.append("&gt;");
				} else if (c == '"') {
					filtered.append("&quot;");
				} else if (c == '&') {
					filtered.append("&amp;");
				} else {
					filtered.append(c);
				}
			}
			return (filtered.toString());
		}
		
		public static boolean isSelectQuery(String query){
			String pattern = "[Ss][Ee][Ll][Ee][Cc][Tt].+";
			//regex to ensure that the query is a select query
			if(validateString(query,pattern)){
				return true;
			}
			else{
				return false;
			}
		}

		public static boolean validateForm(StringBuffer errorMessages, String[] parameters){

			String email = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,3})+$";
			String phone = "^[(]?(\\d{3})[)]?[-\\s]?(\\d{3})[-\\s]?(\\d{4})$";
							
			int counter = 0;
			//check memberid
			if(parameters[counter] == null || parameters[counter] == ""){
				errorMessages.append("<li>Please enter a MemberID</li>");
			}

			//check name
			if(parameters[++counter] == null || parameters[counter] == ""){
				errorMessages.append("<li>Please enter a name</li>");
			}

			//check address
			if(parameters[++counter] == null || parameters[counter] == ""){
				errorMessages.append("<li>Please enter an address</li>");
			}

			//check phone
			if(parameters[++counter] == null || parameters[counter] == "" 
				|| !validateString(parameters[counter],phone)){
				errorMessages.append("<li>Phone number is blank or is not valid</li>");
			}
			
			//check email
			if(parameters[++counter] == null || parameters[counter] == "" 
				|| !validateString(parameters[counter],email)){
				errorMessages.append("<li>Email is blank or is not valid</li>");
			}
			
			if(errorMessages.length() > 0)
				return false;
			else
				return true;
		}

		public static boolean validateString(String text,String pattern){
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(text);
			return(m.matches());
		}

}
