package comp4613.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import comp4613.data.DisplayTable;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class TableHeaderTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	ArrayList<String> columnHeaders = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpSession session = request.getSession();

		columnHeaders = (ArrayList<String>) session
				.getAttribute("arryListColumnNames");

		StringBuffer headerOutPut = new StringBuffer();

		headerOutPut.append(DisplayTable.showHeaders(columnHeaders));

		JspWriter out = pageContext.getOut();
		
		try {
			out.print(headerOutPut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (SKIP_BODY); // Exclude tag body
	}

}
