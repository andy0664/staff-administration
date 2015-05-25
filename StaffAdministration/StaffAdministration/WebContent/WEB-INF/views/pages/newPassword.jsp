<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../includes/bootstrapMeta.jsp" />
<jsp:include page="../includes/bootstrapCss.jsp" />
<jsp:include page="../includes/bootstrapJs.jsp" />
<title>New Password</title>
</head>
<body>

	<div id="wrapper">
		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navigationBar.jsp" />

		<div id="page-wrapper-subpages">
			<div id="page-inner-subpages">
				<div class="page-header">
					<h1>New Password</h1>
				</div>
				<!--  Error message ----------------------------------------------------------- -->
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
				<!--  Error message ----------------------------------------------------------- -->

				<%-- <!--  Warning message ----------------------------------------------------------- -->
		<c:if test="${not empty warningMessage}">
			<div class="alert alert-warning" role="warning">
				${warningMessage}</div>
		</c:if>
		<!--  Warning message ----------------------------------------------------------- --> --%>

				<!--   message ----------------------------------------------------------- -->
				<c:if test="${not empty updateEmployeeMessage}">
					<div class="alert alert-success" role="warning">${message}</div>
				</c:if>
				<!--   message ----------------------------------------------------------- -->

				<div class="row">
					<form class="form-horizontal" method="post" action="updatePassword">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token }" />
						<fieldset>
							<! ----------------  Old Password ---------------- -->
							<div class="form-group">
								<label for="inputOldPassword" class="col-md-2 control-label">Old Password</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="inputOldPassword"
										type="text" name="oldPassword" required>
								</div>
							</div>
							<! ----------------  New Password ---------------- -->
							<div class="form-group">
								<label for="inputNewPassword" class="col-md-2 control-label">New Password</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="inputNewPassword"
										type="text" name="newPassword" required>
								</div>
							</div>
							<! ----------------  New Password Repeat ---------------- -->
							<div class="form-group">
								<label for="inputRepeatPassword" class="col-md-2 control-label">New Password Repeat</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="inputRepeatPassword"
										type="text" name="repeatPassword" required>
								</div>
							</div>
							<! ----------------  buttons ---------------- -->
								<div class="form-group">
									<div class="col-md-10 col-md-offset-2">
										<button type="Submit" class="btn btn-primary">Submit</button>
										<a href="start">
											<button type="button" class="btn btn-default">Cancel</button>
										</a>
									</div>
								</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>


	</div>
	<!--  End of container -->

	<!-- Footer -->
	<%-- 	<jsp:include page="../includes/template/footer.jsp" /> --%>



</body>
</html>
