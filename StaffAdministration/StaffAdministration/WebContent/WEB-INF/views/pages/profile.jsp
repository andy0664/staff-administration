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
				<div class="page-header">
					<h1>${employee.firstName}${employee.lastName}</h1>
				</div>

				<div class="row">
					<div class="col-xs-6">
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<label for="inputFirstName">Firstname</label> <input
									class="form-control" id="inputFirstName" type="text"
									name="firstName" value="<c:out value="${employee.firstName}"/>"
									readonly>
							</div>
							<div class="col-xs-12 col-sm-6">
								<label for="inputLastName">Lastname</label> <input
									class="form-control" id="inputLastName" type="text"
									name="lastName" value="<c:out value="${employee.lastName}"/>"
									readonly>
							</div>

						</div>
					</div>
					<div class="col-xs-4 form-group">
						<div class="row">
							<div class="col-xs-3">
								<label for="inputSSN">SSN</label> <input class="form-control"
									id="inputSSN" type="text" name="ssn"
									value="<c:out value="${employee.ssn}" />" readonly>
							</div>
							<div class="col-xs-4">
								<label for="inputDate">Day of birth</label> <input
									class="form_datetime form-control" id="inputDate"
									placeholder="Date" type="text" readonly name="dayOfBirth"
									value="<fmt:formatDate value="${employee.dayOfBirth}" pattern="dd.MM.yyyy"/>"
									readonly />
							</div>
						</div>
					</div>

					<div class="col-xs-10 form-group">
						<div class="row">
							<div class="col-xs-2">
								<label for="inputZIP">ZIP Code</label> <input
									class="form-control" id="inputZIP" type="text" name="zip"
									value="<c:out value="${employee.address.zip}"/>" readonly>
							</div>
							<div class="col-xs-3">
								<label for="inputCity">City</label> <input class="form-control"
									id="inputCity" type="text" name="city"
									value="<c:out value="${employee.address.city}"/>" readonly>
							</div>
							<div class="col-xs-3">
								<label for="inputStreet">Street</label> <input
									class="form-control" id="inputStreet" type="text" name="street"
									value="<c:out value="${employee.address.street}"/>" readonly>
							</div>
							<div class="col-xs-2">
								<label for="inputCountry">Country</label> <input
									class="form-control" id="inputCountry" type="text"
									name="country"
									value="<c:out value="${employee.address.country}"/>" readonly>
							</div>
						</div>
					</div>

					<div class="col-xs-10 form-group">
						<div class="row">
							<div class="col-xs-4">
								<label for="inputDescription">Job Description</label> <input
									class="form-control" id="inputDescription" type="text"
									name="jobDescription"
									value="<c:out value="${employee.jobDescription}"/>" readonly>
							</div>
							<div class="col-xs-3">
								<label for="inputDepartment">Department</label> <input
									class="form-control" id="inputDepartment" type="text"
									name="department"
									value="<c:out value="${employee.department.name}"/>" readonly>
							</div>
							<div class="col-xs-3">
								<label for="inputDate">Day of Entry</label> <input
									class="form_datetime form-control" id="inputDate"
									placeholder="Date" type="text" readonly name="dayOfEntry"
									value="<fmt:formatDate value="${employee.dayOfEntry}" pattern="dd.MM.yyyy"/>"
									readonly />
							</div>
						</div>
					</div>

					<div class="col-xs-8 form-group">
						<div class="row">
							<div class="col-xs-3">
								<label for="inputTelefon">Telephone</label> <input
									class="form-control" id="inputTelefon" type="text"
									name="telefon" value="<c:out value="${employee.phone}"/>"
									readonly>
							</div>
							<div class="col-xs-5">
								<label for="inputMail">Email</label> <input class="form-control"
									id="inputMail" type="text" name="mail"
									value="<c:out value="${employee.mail}"/>" readonly>
							</div>
						</div>
					</div>
					<form class="form-horizontal" method="post" action="changeRequest">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token }" />
						<div class="col-xs-8 form-group">
							<div class="row">
								<div class="col-xs-8">
									<label for="inputChangeMessage">Change Request</label>
									<textarea class="form-control" id="inputChangeMessage" rows="3"
										name="changeRequest"></textarea>
								</div>
							</div>
						</div>
						<div class="col-xs-8 form-group">
							<button type="Submit" class="btn btn-primary">Send
								Request</button>
						</div>
					</form>
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
