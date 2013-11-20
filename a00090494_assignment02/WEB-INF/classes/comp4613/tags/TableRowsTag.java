package comp4613.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import comp4613.data.DisplayTable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class TableRowsTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	ArrayList<Collection> allRows = new ArrayList<Collection>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		HttpSession session = request.getSession();

		allRows = (ArrayList) session
				.getAttribute("arrayListAllRows");

		StringBuffer headerOutPut = new StringBuffer();

		headerOutPut.append(DisplayTable.showRows(allRows));

		JspWriter out = pageContext.getOut();
		try {
			out.print(headerOutPut.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (SKIP_BODY); // Exclude tag body
	}

}
