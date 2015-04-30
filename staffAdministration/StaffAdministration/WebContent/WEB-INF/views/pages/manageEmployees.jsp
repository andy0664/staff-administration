<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../includes/bootstrapMeta.jsp" />
<title>Employees</title>
<jsp:include page="../includes/bootstrapCss.jsp" />
</head>
<body>


	<div class="container" role="main">

		<div class="page-header">
			<h1>Manage Employees</h1>
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
			<div class="alert alert-success" role="warning">
				${message}</div>
		</c:if>
		<!--   message ----------------------------------------------------------- --> 


		<!--  Search bar ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/searchNav.jsp" />
		<!--  Search bar ----------------------------------------------------------- -->

		<!--  New Employee buttons ----------------------------------------------------------- -->
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p>
					<a href="addEmployee">
						<button type="button" class="btn btn-success">Add new
							Employee</button>
					</a> <a href="fillEmployee">
						<button type="button" class="btn btn-success">Test: Fill</button>
					</a>

				</p>
			</div>
		</div>
		<!--  New Employee buttons ----------------------------------------------------------- -->


		<div class="row">
			<div class="col-md-10 col-md-offset-1">

				<table data-toggle="table" class="table table-striped">
					<thead>
						<tr>
							<th data-sortable="true">SSN</th>
							<th data-sortable="true">First Name</th>
							<th data-sortable="true">Last Name</th>
							<th data-sortable="true">Day of birth</th>
							<th data-sortable="true">Country</th>
							<th data-sortable="true">Street</th>
							<th data-sortable="true">ZIP</th>
							<th data-sortable="true">City</th>
							<th data-sortable="true">Job Description</th>
							<th data-sortable="true">Salary</th>
							<th data-sortable="true">Day of Entry</th>
							<th data-sortable="true">Role</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--  list all employees ----------------------------------------------------------- -->
						<c:forEach items="${employeeList}" var="employee">
							<tr>
								<td>${employee.ssn}</td>
								<td>${employee.firstName}</td>
								<td>${employee.lastName}</td>
								<td><fmt:formatDate value="${employee.dayOfBirth}"
										pattern="dd.MM.yyyy" /></td>
								<td>${employee.address.country}</td>
								<td>${employee.address.street}</td>
								<td>${employee.address.zip}</td>
								<td>${employee.address.city}</td>
								<td>${employee.jobDescription}</td>
								<td>${employee.salary}</td>
								<td><fmt:formatDate value="${employee.dayOfEntry}"
										pattern="dd.MM.yyyy" /></td>
								<td>${employee.role}</td>
								<td><a href="changeEmployee?id=${employee.id}">
										<button type="button" class="btn btn-xs btn-success">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Edit
										</button>
								</a> <a href="deleteEmployee?id=${employee.id}">
										<button type="button" class="btn btn-xs btn-danger">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
											Delete
										</button>
								</a></td>
							</tr>
						</c:forEach>
						<!--  list all employees ----------------------------------------------------------- -->
					</tbody>
				</table>
			</div>
		</div>


	</div>
	<!--  End of container -->

	<jsp:include page="../includes/bootstrapJs.jsp" />
</body>
</html>