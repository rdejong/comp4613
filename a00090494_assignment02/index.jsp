<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../../../WEB-INF/jsp/head.jsp"%>
<body>
<%@ include file="../../../WEB-INF/jsp/headerWrapper.jsp"%>
	<div id="featured-index">&nbsp;</div>
	<div id="banner-wrapper">
		<div id="banner" class="container">
			<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
			<div class="box-left">

				<h2 id="portalTitle">Customer Address Book Portal</h2>
				<span><a href="instructions.html" accesskey="5"
					target="_blank">how to use the address book</a></span>
			</div>
			<div class="box-left">
				<form class="button button-big" name="formId" action="member"
					method="get">
					<input type="hidden" name="formId" value="start"> <input
						type="submit" value="start">
				</form>
			</div>
		</div>
	</div>
	<h2></h2>
	<div id="wrapper">
		<div id="page" class="container">
			<div id="content">
				<div class="title">
					<div id="sidebar">
						<ul class="style1">
							<li class="first">
								<h3>Search for customer</h3>
								<form name="searchCustomer" action="member" method="get">
									Customer Id: <input type="text" name="memberId"> <input
										type="hidden" name="formId" value="retrieveCustomerBean">
									<input type="submit" value="search customer">
								</form>

							</li>
							<li class="first">

								<h3>Customers recently added</h3> <c:forEach items="${cookie}"
									var="currentCookie">
									<!--  
   			 				 Cookie name as map entry key: ${currentCookie.key}<br />
   							 Cookie object as map entry value: ${currentCookie.value}<br />
   							 Name property of Cookie object: ${currentCookie.value.name}<br />
    						 Value property of Cookie object: ${currentCookie.value.value}<br />
							-->
								</c:forEach>
								<table border="1">
									<c:forEach items="${cookie}" var="currentCookie">
										<tr>
											<td>${currentCookie.value.name}</td>
											<td>${currentCookie.value.value}</td>
										</tr>

									</c:forEach>
								</table>
							</li>
							<!--
							<li>
								<h3>Customers recently deleted</h3>

								<table border="1">
									<tr>
										<td>100</td>
										<td>200</td>
										<td>300</td>
									</tr>
									<tr>
										<td>400</td>
										<td>500</td>
										<td>600</td>
									</tr>
								</table>
							</li>
							  -->
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>
