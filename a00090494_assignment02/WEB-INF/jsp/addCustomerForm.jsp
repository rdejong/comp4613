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