<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="headerStuff">
	<%!int pageCount = 0;

	void addCount() {
		pageCount++;
	}%>
	<%
		addCount();
	%>
	<h3>BCIT Advanced Java Development Program</h3>
	<p>
		This site has been visited
		<%=pageCount%>
		times.
	</p>
	<br />
	<p>
		It is now:
		<fmt:formatDate value="<%=new java.util.Date()%>"
			pattern="E, yyyy-MM-dd h:mm:ss a" />
	</p>



	<%
		if (request.getRemoteUser() == null) {
	%>
	<h3>you are not logged in</h3>
	<%
		}
	%>
	<%
		if (request.isUserInRole("guest")) {
	%>
	<h3>
		logged in as:
		<%=request.getRemoteUser()%>

	</h3>
	<%
		}
	%>


</div>

