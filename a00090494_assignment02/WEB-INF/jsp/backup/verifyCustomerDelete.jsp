<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>verify delete customer page</title>
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
<link rel="stylesheet" media="screen" href="comp4613/css/styles.css">
</head>
<body>
	<div id="header-wrapper">
		<div id="banner-wrapper">
			<div id="banner" class="container">
				<div id="featured-confirmDelete"></div>
				<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
				<div class="box-left">
					<h2>are you sure you want to delete this customer?</h2>
					<br />
					<table class="atAGlanceLeft">
						<tr>
							<th>Customer Id Number:</th>
							<td>${confirmDelete.memberId}</td>
						</tr>
						<tr>
							<th>First Name:</th>
							<td>${confirmDelete.firstName}</td>
						</tr>
						<tr>
							<th>Last Name:</th>
							<td>${confirmDelete.lastName}</td>
						</tr>
						<tr>
							<th>Address:</th>
							<td>${confirmDelete.address}</td>
						</tr>
						<tr>
							<th>City:</th>
							<td>${confirmDelete.city}</td>
						</tr>
						<tr>
							<th>Code:</th>
							<td>${confirmDelete.code}</td>
						</tr>
						<tr>
							<th>Country:</th>
							<td>${confirmDelete.country}</td>
						</tr>
						<tr>
							<th>Phone:</th>
							<td>${confirmDelete.phone}</td>
						</tr>
						<tr>
							<th>Email:</th>
							<td>${confirmDelete.email}</td>
						</tr>
					</table>
				</div>
				<br />
				<div class="box-left">
					<form class="button button-big" name="formId" action="member"
						method="get">
						<input type="hidden" name="formId" value="start"> <input
							type="submit" value="No, take me to the start page">
					</form>
				</div>
				<div class="box-left">
				<form class="button button-big" name="formId" action="member"
						method="get">
						<input type="hidden" name="formId" value="deleteCustomer">
						<input type="hidden" name="customerId" value="${confirmDelete.memberId}"> 
						<input type="submit" value="Yes, delete customer please!">
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="containerError"></div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>