<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../includes/bootstrapMeta.jsp" />
<title>Profile</title>
<jsp:include page="../includes/bootstrapCss.jsp" />
</head>
<body>
	<div id="wrapper">

		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navigationBar.jsp" />


		<div id="page-wrapper-subpages">
			<div id="page-inner-subpages">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<! ----------------  ssn ---------------- -->
						<div class="form-group">
							<label for="inputSSN" class="col-md-2 control-label">SSN</label>
							<div class="col-md-5">
								<input class="form-control" id="inputSSN" type="text" name="ssn"
									value="<c:out value="${employee.ssn}" />" readonly>
							</div>
						</div>

						<! ----------------  first Name ---------------- -->
						<div class="form-group">
							<label for="inputFirstName" class="col-md-2 control-label">First
								Name</label>
							<div class="col-md-5">
								<input class="form-control" id="inputFirstName" type="text"
									name="firstName" value="<c:out value="${employee.firstName}"/>"
									readonly>
							</div>
						</div>
						<! ----------------  last Name ---------------- -->
						<div class="form-group">
							<label for="inputLastName" class="col-md-2 control-label">Last
								Name</label>
							<div class="col-md-5">
								<input class="form-control" id="inputLastName" type="text"
									name="lastName" value="<c:out value="${employee.lastName}"/>"
									readonly>
							</div>
						</div>

						<! ----------------  dayOfBirth ---------------- -->
						<div class="form-group">
							<label for="inputDate" class="col-md-2 control-label">Day
								of Birth</label>
							<div class="col-md-5">
								<input class="form_datetime" id="inputDate" placeholder="Date"
									type="text" readonly name="dayOfBirth"
									value="<fmt:formatDate value="${employee.dayOfBirth}" pattern="dd.MM.yyyy"/>"
									readonly /> <i class="fa fa-calendar"></i>
							</div>
						</div>

						<! ----------------  Street ---------------- -->
						<div class="form-group">
							<label for="inputStreet" class="col-md-2 control-label">Street</label>
							<div class="col-md-5">
								<input class="form-control" id="inputStreet" type="text"
									name="street"
									value="<c:out value="${employee.address.street}"/>" readonly>
							</div>
						</div>

						<! ----------------  ZIP Code ---------------- -->
						<div class="form-group">
							<label for="inputZIP" class="col-md-2 control-label">ZIP
								Code</label>
							<div class="col-md-5">
								<input class="form-control" id="inputZIP" type="text" name="zip"
									value="<c:out value="${employee.address.zip}"/>" readonly>
							</div>
						</div>

						<! ----------------  City ---------------- -->
						<div class="form-group">
							<label for="inputCity" class="col-md-2 control-label">City</label>
							<div class="col-md-5">
								<input class="form-control" id="inputCity" type="text"
									name="city" value="<c:out value="${employee.address.city}"/>"
									readonly>
							</div>
						</div>

						<! ----------------  Country ---------------- -->
						<div class="form-group">
							<label for="inputCountry" class="col-md-2 control-label">Country</label>
							<div class="col-md-5">
								<input class="form-control" id="inputCountry" type="text"
									name="country"
									value="<c:out value="${employee.address.country}"/>" readonly>
							</div>
						</div>

						<! ----------------  Berufsbezeichnung ---------------- -->
						<div class="form-group">
							<label for="inputDescription" class="col-md-2 control-label">Job
								Description</label>
							<div class="col-md-5">
								<input class="form-control" id="inputDescription"
									type="jobDescription" name="jobDescription"
									value="<c:out value="${employee.jobDescription}"/>" readonly>
							</div>
						</div>

						<! ----------------  EntryDate ---------------- -->
						<div class="form-group">
							<label for="inputDate" class="col-md-2 control-label">Day
								of Entry</label>
							<div class="col-md-5">
								<input class="form_datetime" id="inputDate" placeholder="Date"
									type="text" readonly name="dayOfEntry"
									value="<fmt:formatDate value="${employee.dayOfEntry}" pattern="dd.MM.yyyy"/>"
									readonly /> <i class="fa fa-calendar"></i>
							</div>
						</div>

						<! ---------------  Department ---------------- -->
						<div class="form-group">
							<label for="inputDepartment" class="col-md-2 control-label">Department</label>
							<div class="col-md-5">
								<input class="form-control" id="inputDepartment" type="text"
									name="department"
									value="<c:out value="${employee.department.name}"/>" readonly>
							</div>
						</div>
						<form class="form-horizontal" method="post" action="changeRequest">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token }" /> <input type="hidden" name="userName"
								value="${employee.userName}" />
								
							<! ---------------  Change Request ---------------- -->
							<div class="form-group">
								<label for="inputChangeMessage" class="col-md-2 control-label">Change
									Request</label>
								<div class="col-md-5">
									<input class="form-control" id="inputChangeMessage" type="text"
										name="changeRequest">
								</div>
							</div>
							<! ----------------  buttons ---------------- -->
							<div class="form-group">
								<div class="col-md-10 col-md-offset-2">
									<button type="Submit" class="btn btn-primary">Send
										Request</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!--  End of container -->


	<!-- JS for Bootstrap -->
	<%@include file="../includes/bootstrapJs.jsp"%>
	<!-- JS for Bootstrap -->

	<!-- Footer -->
	<%-- 	<jsp:include page="../includes/template/fixedFooter.jsp" /> --%>

</body>
</html>