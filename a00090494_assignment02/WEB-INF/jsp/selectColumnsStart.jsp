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
					<span><a href="instructions.html" accesskey="5" title="">how to use the
							address book</a></span>
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
					<%@ taglib uri="/WEB-INF/lib/labTag.tld" prefix="labTag" %>
					<labTag:columnSelect />
				</div>
				<div class="atAGlanceLeft">
					<h2>customer table</h2>
						<labTag:tableHeader />
						<labTag:tableRows/>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../../WEB-INF/jsp/footer.jsp"%>
</body>
</html>