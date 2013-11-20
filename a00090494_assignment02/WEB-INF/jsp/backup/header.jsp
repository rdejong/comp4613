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
<p>
	logged in as:
	<%=request.getRemoteUser()%>

</p>
<h3>
	<a href="logout">logout</a>
</h3>


<h3>
	<a href="user.jsp">back to query page</a>
</h3>

</div>

