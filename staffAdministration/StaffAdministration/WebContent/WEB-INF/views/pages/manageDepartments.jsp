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
	<!--  Search bar ----------------------------------------------------------- -->
	<jsp:include page="../includes/template/navigationBar.jsp" />
	<!--  Search bar ----------------------------------------------------------- -->

	<div class="container" role="main">

		<div class="page-header">
			<h1>Manage Departments</h1>
		</div>

		 <!--  Error message ----------------------------------------------------------- -->
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
		<!--  Error message ----------------------------------------------------------- -->

		<!--  Warning message ----------------------------------------------------------- -->
		<%--<c:if test="${not empty warningMessage}">
			<div class="alert alert-warning" role="warning">
				${warningMessage}</div>
		</c:if>
		<!--  Warning message ----------------------------------------------------------- -->

		<!--   message ----------------------------------------------------------- -->
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="warning">
				${message}</div>
		</c:if>
		<!--   message ----------------------------------------------------------- --> --%>


		<!--  Search bar ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/searchNav.jsp" />
		<!--  Search bar ----------------------------------------------------------- -->

		<!--  New Employee buttons ----------------------------------------------------------- -->
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p>
					<a href="addDepartment">
						<button type="button" class="btn btn-success">Add new
							Department</button>
					</a> <a href="fillDepartment">
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
							<th data-sortable="true">Shortcut</th>
							<th data-sortable="true">Name</th>
							<th data-sortable="true">Manager</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--  list all employees ----------------------------------------------------------- -->
						<c:forEach items="${departmentList}" var="department">
							<tr>
								<td>${department.shortcut}</td>
								<td>${department.name}</td>
								<td>${department.manager.firstName} ${department.manager.lastName}</td>
								<td><a href="changeDepartment?id=${department.id}">
										<button type="button" class="btn btn-xs btn-success">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Edit
										</button>
								</a> <a href="deleteDepartment?id=${department.id}">
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
