<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Show Error Page</title>
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
<link href="comp4613/css/default-2.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<div id="header-wrapper">
		<div id="banner-wrapper">
			<div id="banner" class="container">
				<div id="featured-error"></div>
				<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
				<br />
				<h1>Oops...something has gone wrong</h1>
				<br />
				<h3>customer number is not valid or customer has been deleted</h3>
				<h3>please try again</h3>
				<br />
				<form class="button button-big" name="formId" action="member"
					method="get">
					<input type="hidden" name="formId" value="start"> <input
						type="submit" value="start">
				</form>
			</div>
		</div>
	</div>
	<div id="containerError"></div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>