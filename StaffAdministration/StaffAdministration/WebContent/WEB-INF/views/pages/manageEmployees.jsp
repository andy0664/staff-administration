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
<title>Employees</title>
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
					<div class="alert alert-success" role="warning">${message}</div>
				</c:if>
				<!--   message ----------------------------------------------------------- -->

				<div class="row">
					<div class="col-md-12">
						<sec:authorize access="hasRole('ADMIN')">
							<div id="toolbar" class="btn-group">
								<a href="addEmployee">
									<button type="button" class="btn btn-success">
										<i class="fa fa-user-plus"></i> Add Employee
									</button>
								</a> <a href="fillEmployee">
									<button type="button" class="btn btn-success">Test:
										Fill</button>
								</a>
							</div>
						</sec:authorize>

						<table data-toggle="table" class="table table-striped"
							data-sort-name="name" data-sort-order="desc"
							data-url="/gh/get/response.json/wenzhixin/bootstrap-table/tree/master/docs/data/data1/"
							data-show-columns="true" data-search="true"
							data-toolbar="#toolbar" data-height="755" data-show-toggle="true">
							<thead>
								<tr>
									<th data-sortable="true">SSN</th>
									<th data-sortable="true">First Name</th>
									<th data-sortable="true">Last Name</th>
									<th data-sortable="true">Day of birth</th>
									<th data-sortable="true">Department</th>
									<th data-sortable="true">Username</th>
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
										<td>${employee.department.name}</td>
										<td>${employee.userName}</td>
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
										<sec:authorize access="hasRole('ADMIN')">
										</a> <a href="deleteEmployee?id=${employee.id}">
												<button type="button" class="btn btn-xs btn-danger">
													<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
													Delete
												</button>
										</a>
										</sec:authorize>
										</td>
									</tr>
								</c:forEach>
								<!--  list all employees ----------------------------------------------------------- -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!--  End of container -->

	<!-- Footer -->
	<%-- 	<jsp:include page="../includes/template/footer.jsp" /> --%>



</body>
</html>
