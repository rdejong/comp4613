<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../../../WEB-INF/jsp/head.jsp"%>
<link rel="stylesheet" media="screen" href="comp4613/css/styles.css">
<body>
<%@ include file="../../../WEB-INF/jsp/headerWrapper.jsp"%>
	<div id="featured">&nbsp;</div>
	<div id="banner-wrapper">
		<div id="banner" class="container">
			<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
			<form name="searchCustomerForm" class="addMemberForm"
				onsubmit="return addMemberFormValidator()" action="member"
				method="get" autocomplete="on">
				<ul>
					<li>
						<h2>Retrieve Customer Information</h2> <br />
						<p>enter customer id number
						<p>
							<span class="required_notification">** Denotes Required
								Field</span>
					</li>
					<li><label for="memberId">**Customer Number:</label> <textarea
							name="memberId" cols="10" rows="1"></textarea></li>

					<li><label for="lastName">Last Name:</label> <input
						type="text" readonly name="lastName" placeholder="Doe" /></li>

					<li><label for="firstName">First Name:</label> <input readonly
						type="text" name="firstName" placeholder="John" /></li>

					<li><label for="address">Address:</label> <input type="text"
						readonly name="address" placeholder="1234 Anywhere Street" /></li>

					<li><label for="city">City:</label> <input type="text"
						readonly name="city" placeholder="Vancouver" /></li>

					<li><label for="code">Code:</label> <input type="text"
						readonly name="code" placeholder="H0H 0H0" /></li>

					<li><label for="country">Country:</label> <input type="text"
						readonly name="country" placeholder="CANADA" /></li>

					<li><label for="phone">Phone:</label> <input type="text"
						readonly name="phone" placeholder="604-555-1212" /></li>

					<li><label for="email">Email:</label> <input type="email"
						readonly name="email" placeholder="john_doe@example.com" /></li>

					<li><input type="hidden" name="formId"
						value="retrieveCustomerBean">
						<button class="submit" type="submit">retrieve customer
							information</button></li>
				</ul>
			</form>
		</div>
	</div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
	<script type="text/javascript" src="comp4613/js/formValidate.js"></script>
</body>
</html>