<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>Success!</title>
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
				<div id="featured-success"></div>
				<%@ include file="../../../WEB-INF/jsp/header.jsp"%>		
				<div class="box-left">
				<h2>customer successfully added or modified</h2>
				<br />
			 <table class="atAGlanceLeft">
            <tr>
                <th>First Name:</th>
                <td>${customerBean.firstName}</td>
            </tr>
             <tr>
                <th>Last Name:</th>
                <td>${customerBean.lastName}</td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>${customerBean.address}</td>
            </tr>
            <tr>
                <th>City:</th>
                <td>${customerBean.city}</td>
            </tr>
            <tr>
                <th>Code:</th>
                <td>${customerBean.code}</td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>${customerBean.country}</td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>${customerBean.phone}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${customerBean.email}</td>
            </tr>
        </table>
   </div>
				<br />
				<div class="box-left">
				<form class="button button-big" name="formId" action="member"
					method="get">
					<input type="hidden" name="formId" value="start"> <input
						type="submit" value="start">
				</form>
				</div>
			</div>
		</div>
	</div>
	<div id="containerError"></div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>