<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Vector"%>

<!DOCTYPE html>
<!--
COMP 4613-Lab01
Rodney deJong
A00090494
October 06, 2013
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>COMP 4613 - Rodney deJong A00090494</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
	rel="stylesheet" />
<link href="comp4613/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="comp4613/css/startCss.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">BCIT Comp 4613</a>
				</h1>
				<p>Name: Rodney deJong Student Number: A00090494</p>
			</div>
			<div id="menu">
				<ul>
					<li><a href="comp4613/labs.jsp" accesskey="1" title="">Weekly
							Labs</a></li>
					<li><a href="#" accesskey="2" title="">Lecture Notes</a></li>
					<li><a href="#" accesskey="3" title="">BCIT</a></li>
					<li><a href="#" accesskey="4" title="">Program Information</a></li>
					<li><a href="#" accesskey="5" title="">Contact Me</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="featured">&nbsp;</div>
	<div id="banner-wrapper">
		<div id="banner" class="container">
			<%@ include file="../../../WEB-INF/jsp/header.jsp"%>

			<div class="box-left">
				<div class="atAGlanceLeft">
					<h2>address book start page</h2>
					<span><a href="instructions.html" accesskey="5" title="">how to use the
							address book</a></span>
					<div class="box-right">
						<form class="button button-big" name="formId" action="member"
							method="get">
							<input type="hidden" name="formId" value="addCustomer"> <input
								type="submit" value="add a customer">
						</form>
					</div>
					<div class="box-left">
						<form class="button button-big" name="formId" action="member"
							method="get">
							<input type="hidden" name="formId" value="searchCustomer">
							<input type="submit" value="modify customer information">
						</form>
					</div>
					<%@ taglib uri="/WEB-INF/lib/labTag.tld" prefix="labTag" %>
					<labTag:columnSelect />
				</div>
				<div class="atAGlanceLeft">
				 <%-- For every String[] item of paramValues... --%>
      <c:forEach var='parameter' items='${custSelectCol}'> 
         <ul>
            <%-- Show the key, which is the request parameter
                 name --%>
     

            <%-- Iterate over the values -- a String[] -- 
                 associated with this request parameter --%>
            <c:forEach var='value' items='${request.parameter.value}'>
               <%-- Show the String value --%>
               <c:out value='${value}'/>   
            </c:forEach>
         </ul>
      </c:forEach>
					<h2>customer table</h2>
					<table border="1">
						<tr>
							<c:forEach var="custCols" items="${custSelectCol}">
								<th><c:out value="${custCols}" /></th>
							</c:forEach>
							<th><c:out value="add/modify"></c:out></th>
							
						</tr>
				
						<c:forEach var="customerBean" items="${customerListVector}">
							<tr>
								<td><c:out
										value="${customerBean.lastName}" /></td>
							 	<td><c:out value="${customerBean.firstName}" /></td>
								<td><c:out value="${customerBean.phone}" /></td>
								<!-- <td><c:out value="${customerBean.address}" /></td>
								<td><c:out value="${customerBean.city}" /></td>
								<td><c:out value="${customerBean.code}" /></td>
								<td><c:out value="${customerBean.country}" /></td>
								<td><c:out value="${customerBean.phone}" /></td>
								<td><c:out value="${customerBean.email}" /></td>
								-->
								<td><c:out value="" />
									<form action="member" method="get">
										<input type="hidden" name="formId" value="verifyCustomerDelete">
										<input type="hidden" name="memberId"
											value="${customerBean.memberId}"> <input
											type="submit" value="delete">
									</form>
									<form action="member" method="get">
										<input type="hidden" name="formId"
											value="retrieveCustomerBean"> <input type="hidden"
											name="memberId" value="${customerBean.memberId}"><input
											type="submit" value="modify">
									</form></td>				
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>