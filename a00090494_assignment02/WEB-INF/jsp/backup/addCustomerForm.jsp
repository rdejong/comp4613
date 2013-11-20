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
<link rel="stylesheet" media="screen" href="comp4613/css/styles.css">

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
			<form name="addMemberForm" class="addMemberForm"
				onsubmit="return addMemberFormValidator()" action="member"
				method="post" autocomplete="on">

				<ul>
					<li>
						<h2>add a customer</h2> <span class="required_notification">*
							Denotes Required Field</span>
					</li>

					<li><label for="member_Id">Membership Number:</label> <textarea
							readonly name="Member_Id" cols="10" rows="1"></textarea></li>

					<li><label for="lastName">Last Name:</label> <input
						type="text" name="lastName" placeholder="Doe" /></li>

					<li><label for="firstName">First Name:</label> <input
						type="text" name="firstName" placeholder="John" required /></li>

					<li><label for="address">Address:</label> <input type="text"
						name="address" placeholder="1234 Anywhere Street" required /></li>

					<li><label for="city">City:</label> <input type="text"
						name="city" placeholder="Vancouver" required /></li>

					<li><label for="code">Code:</label> <input type="text"
						name="code" placeholder="H0H 0H0" required /></li>

					<li><label for="country">Country:</label> <input type="text"
						name="country" placeholder="CANADA" required /></li>

					<li><label for="phone">Phone:</label> <input type="text"
						name="phone" placeholder="604-555-1212" required /></li>

					<li><label for="email">Email:</label> <input type="email"
						name="email" placeholder="john_doe@example.com" required /></li>

					<li><input type="hidden" name="formId" value="addCustomer">
						<button class="submit" type="submit">Submit Form</button></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>