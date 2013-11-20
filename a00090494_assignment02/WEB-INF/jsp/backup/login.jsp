<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<!--
COMP 4613-Lab07
Rodney deJong
A00090494
October 06, 2013
-->
<html>
<head>

<title>Lab 07</title>

<link href="comp4613/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="comp4613/js/formValidate.js"></script>
</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">BCIT Comp 4613</a>
				</h1>
				<p>Rodney deJong-A00090494</p>
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
			<form class="button button-select" name="select"
				action="j_security_check" method="post">
				<fieldset>
					<legend>enter site</legend>
					<br /> <br /> username: <input type="text" name="j_username"><br />
					<br /> password:<input type="password" name="j_password"><br />
					<br /> <input type="submit" name="input" value="enter">
				</fieldset>
			</form>
		</div>
	</div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>