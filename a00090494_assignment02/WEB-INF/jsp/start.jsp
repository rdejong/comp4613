<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../../../WEB-INF/jsp/head.jsp"%>
<body>
<%@ include file="../../../WEB-INF/jsp/headerWrapper.jsp"%>
	<div id="featured">&nbsp;</div>
	<div id="banner-wrapper">
		<div id="banner" class="container">
			<%@ include file="../../../WEB-INF/jsp/header.jsp"%>
			<div class="box-left">
				<div class="atAGlanceLeft">
					<h2>address book start page</h2>
					<span><a href="instructions.html" accesskey="5" title="">how
							to use the address book</a></span>
					<div class="box-right">
						<form class="button button-big" name="formId" action="member"
							method="get">
							<input type="hidden" name="formId" value="addCustomer"> <input
								type="submit" value="add a customer">
						</form>
					</div>
					<div class="box-left">
						<form class="button button-big" name="formId" action="member"
							method="get">
							<input type="hidden" name="formId" value="searchCustomer">
							<input type="submit" value="modify customer information">
						</form>
					</div>
				</div>
				<div class="atAGlanceLeft">
					<div class="box-left">
						<form class="button button-select" name="checkBoxId"
							action="member" method="get">
							<fieldset>
								<legend>select the columns you need</legend>
								<input type=checkbox name="column" value="memberId" checked>memberId<input type=checkbox name="column" value="lastName" checked>last
								name <input type=checkbox name="column" value="firstName"
									checked>first name <input type=checkbox name="column"
									value="address" checked>address <input type=checkbox
									name="column" value="city" checked>city<br> <input
									type=checkbox name="column" value="code" checked>code<input
									type=checkbox name="column" value="country" checked>country
								<input type=checkbox name="column" value="phone" checked>phone
								<input type=checkbox name="column" value="email" checked>email<br />
								<br /> <input type="submit" value="select">
							</fieldset>
							<input type="hidden" name="formId" value="selectColumnsStart">
						</form>
					</div>
					<div class="atAGlanceLeft">
						<h2>customer table</h2>
						<labTag:tableHeader />
						<labTag:tableRows/>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>