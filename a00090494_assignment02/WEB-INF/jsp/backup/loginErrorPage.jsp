<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>possible database error</title>
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
				<div id="featured-dbError"></div>
				<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
				<div class="box-left">
					<h2>we have a problem</h2>
					<br />
					<h3>there seems to be an issue with your permissions - you don't have any</h3>
					<br />
					<%-- Loop over the JSTL header implicit object, which is a 
           map --%>
					<c:forEach items='${header}' var='h'>
						<ul>
							<%-- Display the key of the current item, which
                 represents the request header name and the
                 current item's value, which represents the
                 header value --%>
							<li>Header Name: <c:out value='${h.key}' /></li>
							<li>Header Value: <c:out value='${h.value}' /></li>
						</ul>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div id="containerError"></div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>