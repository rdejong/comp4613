package comp4613.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import java.io.*;

public class ColumnSelectTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		HttpSession session = request.getSession();

		String[] paramValues = (String[]) session.getAttribute("custSelectCol");

		JspWriter out = pageContext.getOut();
		try {
			out.println("<h1 >Columns Selected</h1>");

			for (int i = 0; i < paramValues.length; i++) {

				out.println(paramValues[i] + "<br />");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (SKIP_BODY); // Exclude tag body
	}

}
