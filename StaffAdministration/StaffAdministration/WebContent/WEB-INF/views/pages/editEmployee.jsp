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
<title>Employees</title>
<jsp:include page="../includes/bootstrapCss.jsp" />
<link
	href="http://www.malot.fr/bootstrap-datetimepicker/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet">

</head>
<body>
	<div id="wrapper">

		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navigationBar.jsp" />




		<div id="page-wrapper-subpages">
			<div id="page-inner-subpages">
				<!--  Error message ----------------------------------------------------------- -->
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
				<!--  Error message ----------------------------------------------------------- -->
				<!--  add or edit?  ----------------------------------------------------------- -->
				<c:choose>
					<c:when test="${not empty employee}">
						<c:set var="legend">Change Employee: ${employee.firstName} ${employee.lastName}</c:set>
						<c:set var="formAction">changeEmployee</c:set>
					</c:when>
					<c:otherwise>
						<c:set var="legend">New Employee</c:set>
						<c:set var="formAction">addEmployee</c:set>
					</c:otherwise>
				</c:choose>
				<!--  add or edit?  ----------------------------------------------------------- -->

				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<form class="form-horizontal" method="post" action="${formAction}">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token }" />
							<fieldset>
								<legend>${legend}</legend>
								<input type="hidden" name="id" value="${employee.id }" />
								<! ----------------  ssn ---------------- -->
								<div class="form-group">
									<label for="inputSSN" class="col-md-2 control-label">SSN</label>
									<div class="col-md-5">
										<input class="form-control" id="inputSSN" type="number"
											name="ssn"
											value="<c:out value="${employee.ssn}"/><c:out value="${tmpEmployee.ssn}"/>"
											required>
									</div>
								</div>

								<! ----------------  first Name ---------------- -->
								<div class="form-group">
									<label for="inputFirstName" class="col-md-2 control-label">First
										Name</label>
									<div class="col-md-5">
										<input class="form-control" id="inputFirstName" type="text"
											name="firstName"
											value="<c:out value="${employee.firstName}"/><c:out value="${tmpEmployee.firstName}"/>"
											required>
									</div>
								</div>
								<! ----------------  last Name ---------------- -->
								<div class="form-group">
									<label for="inputLastName" class="col-md-2 control-label">Last
										Name</label>
									<div class="col-md-5">
										<input class="form-control" id="inputLastName" type="text"
											name="lastName"
											value="<c:out value="${employee.lastName}"/><c:out value="${tmpEmployee.lastName}"/>"
											required>
									</div>
								</div>

								<! ----------------  dayOfBirth ---------------- -->
								<div class="form-group">
									<label for="inputDate" class="col-md-2 control-label">Day
										of Birth</label>
									<div class="col-md-5">
										<input class="form_datetime" id="inputDate" placeholder="Date"
											type="text" readonly name="dayOfBirth"
											value="<fmt:formatDate value="${employee.dayOfBirth}" pattern="dd.MM.yyyy"/><fmt:formatDate value="${tmpEmployee.dayOfBirth}" pattern="dd.MM.yyyy"/>"
											required /> <i class="fa fa-calendar"></i>
									</div>
								</div>

								<! ----------------  Street ---------------- -->
								<div class="form-group">
									<label for="inputStreet" class="col-md-2 control-label">Street</label>
									<div class="col-md-5">
										<input class="form-control" id="inputStreet" type="text"
											name="street"
											value="<c:out value="${employee.address.street}"/><c:out value="${addressTmp.street}"/>"
											required>
									</div>
								</div>

								<! ----------------  ZIP Code ---------------- -->
								<div class="form-group">
									<label for="inputZIP" class="col-md-2 control-label">ZIP
										Code</label>
									<div class="col-md-5">
										<input class="form-control" id="inputZIP" type="number"
											name="zip"
											value="<c:out value="${employee.address.zip}"/><c:out value="${addressTmp.zip}"/>"
											required>
									</div>
								</div>

								<! ----------------  City ---------------- -->
								<div class="form-group">
									<label for="inputCity" class="col-md-2 control-label">City</label>
									<div class="col-md-5">
										<input class="form-control" id="inputCity" type="text"
											name="city"
											value="<c:out value="${employee.address.city}"/><c:out value="${addressTmp.city}"/>"
											required>
									</div>
								</div>

								<! ----------------  Country ---------------- -->
								<div class="form-group">
									<label for="inputCountry" class="col-md-2 control-label">Country</label>
									<div class="col-md-5">
										<input class="form-control" id="inputCountry" type="text"
											name="country"
											value="<c:out value="${employee.address.country}"/><c:out value="${addressTmp.country}"/>"
											required>
									</div>
								</div>

								<! ----------------  Mail ---------------- -->
								<div class="form-group">
									<label for="inputMail" class="col-md-2 control-label">E-Mail</label>
									<div class="col-md-5">
										<input class="form-control" id="inputMail" type="text"
											name="mail"
											value="<c:out value="${employee.mail}"/><c:out value="${tmpEmployee.mail}"/>">
									</div>
								</div>

								<! ----------------  Telefon ---------------- -->
								<div class="form-group">
									<label for="inputTelefon" class="col-md-2 control-label">Telefon</label>
									<div class="col-md-5">
										<input class="form-control" id="inputTelefon" type="text"
											name="phone"
											value="<c:out value="${employee.phone}"/><c:out value="${tmpEmployee.phone}"/>">
									</div>
								</div>

								<! ----------------  Berufsbezeichnung ---------------- -->
								<div class="form-group">
									<label for="inputDescription" class="col-md-2 control-label">Job
										Description</label>
									<div class="col-md-5">
										<input class="form-control" id="inputDescription"
											type="jobDescription" name="jobDescription"
											value="<c:out value="${employee.jobDescription}"/><c:out value="${tmpEmployee.jobDescription}"/>"
											required>
									</div>
								</div>

								<! ----------------  Gehalt ---------------- -->
								<div class="form-group">
									<label for="inputSalary" class="col-md-2 control-label">Salary</label>
									<div class="col-md-5">
										<input class="form-control" id="inputSalary" type="text"
											name="salary"
											value="<c:out value="${employee.salary}"/><c:out value="${tmpEmployee.salary}"/>"
											required>
									</div>
								</div>

								<! ----------------  EntryDate ---------------- -->
								<div class="form-group">
									<label for="inputDate" class="col-md-2 control-label">Day
										of Entry</label>
									<div class="col-md-5">
										<input class="form_datetime" id="inputDate" placeholder="Date"
											type="text" readonly name="dayOfEntry"
											value="<fmt:formatDate value="${employee.dayOfEntry}" pattern="dd.MM.yyyy"/><fmt:formatDate value="${tmpEmployee.dayOfEntry}" pattern="dd.MM.yyyy"/>"
											/required> <i class="fa fa-calendar"></i>
									</div>
								</div>


								<! ---------------  Department ---------------- -->
								<div class="form-group">
									<label for="inputDepartment" class="col-md-2 control-label">Department</label>
									<div class="col-md-5">
										<select class="form-control" name="department">
											<option value="-1" selected="selected">No Department</option>
											<c:forEach items="${departmentList }" var="department">
												<c:choose>
													<c:when test="${employee.department.name==department.name}">
														<option value="${department.id}" selected="selected">${department.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${department.id}">${department.name}</option>
													</c:otherwise>
												</c:choose>

											</c:forEach>
										</select>
									</div>
								</div>
								<sec:authorize access="hasRole('ADMIN')">
									<! ----------------  User Name ---------------- -->
									<div class="form-group">
										<label for="inputUserName" class="col-md-2 control-label">Username</label>
										<div class="col-md-5">
											<input class="form-control" id="inputUserName" type="text"
												name="userName"
												value="<c:out value="${employee.userName}"/><c:out value="${tmpEmployee.userName}"/>"
												required>
										</div>
									</div>

									<! ----------------  Password ---------------- -->
									<div class="form-group">
										<label for="inputPassword" class="col-md-2 control-label">Password</label>
										<div class="col-md-5">
											<input type="password" class="form-control"
												id="inputPassword" type="text" name="password"
												value="<c:out value="${employee.password}"/>" required>
										</div>
									</div>

									<! ---------------  Role ---------------- -->
									<div class="form-group">
										<label for="inputRole" class="col-md-2 control-label">Role</label>
										<div class="col-md-5">
											<select class="form-control" name="role">
												<c:choose>
													<c:when test="${employee.role=='ROLE_ADMIN'}">
														<option value="ROLE_ADMIN" selected="selected">Administrator</option>
														<option value="ROLE_MANAGER">Manager</option>
														<option value="ROLE_EMPLOYEE">Employee</option>
													</c:when>
													<c:when test="${employee.role=='ROLE_MANAGER'}">
														<option value="ROLE_ADMIN">Administrator</option>
														<option value="ROLE_MANAGER" selected="selected">Manager</option>
														<option value="ROLE_EMPLOYEE">Employee</option>
													</c:when>
													<c:otherwise>
														<option value="ROLE_ADMIN">Administrator</option>
														<option value="ROLE_MANAGER">Manager</option>
														<option value="ROLE_EMPLOYEE" selected="selected">Employee</option>
													</c:otherwise>
												</c:choose>
											</select>
										</div>
									</div>
								</sec:authorize>
								<! ----------------  buttons ---------------- -->
								<div class="form-group">
									<div class="col-md-10 col-md-offset-2">
										<button type="Submit" class="btn btn-primary">Submit</button>
										<a href="manageEmployees">
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

	</div>
	<!--  End of container -->


	<!-- JS for Bootstrap -->
	<%@include file="../includes/bootstrapJs.jsp"%>
	<!-- JS for Bootstrap -->

	<!-- Footer -->
	<%-- 	<jsp:include page="../includes/template/fixedFooter.jsp" /> --%>


	<!-- JS for Datetime picker -->

	<script type="text/javascript"
		src="http://www.malot.fr/bootstrap-datetimepicker/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>

	<script>
		$(function() {
			$(".form_datetime").datetimepicker({
				format : "dd.mm.yyyy",
				autoclose : true,
				todayBtn : true,
				pickerPosition : "bottom-left",
				minView : 2
			});
		});
	</script>
</body>
</html>
