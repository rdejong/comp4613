<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Vector"%>
<%@ taglib uri="/WEB-INF/lib/labTag.tld" prefix="labTag"%>
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
<meta name="descriptiion" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
	rel="stylesheet" />
<link href="comp4613/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="comp4613/css/startCss.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">BCIT Comp 4613</a>
				</h1>
				<p>Rodney deJong Student - A00090494</p>
			</div>
			<div id="menu">
				<ul>
					<li><a href="#" accesskey="1" title="">Weekly
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

			<h2>query output table</h2>
			<p>results from the query: ${lastQueryInput}</p>
			<div class="tableOutPut">
			
				<labTag:tableHeader />
				<labTag:tableRows />
				
			</div>
		</div>

		</div>

	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>