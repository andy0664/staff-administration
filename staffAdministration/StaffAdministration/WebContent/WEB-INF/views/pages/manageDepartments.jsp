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
<jsp:include page="../includes/bootstrapJs.jsp" />
</head>
<body>

	<div id="wrapper">
		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="../includes/template/navigationBar.jsp" />

		<div id="page-wrapper">
			<div id="page-inner-subpages">
				<c:set var="lastDepartment">""</c:set>
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
		
		<table data-toggle="table"
       data-url="/gh/get/response.json/wenzhixin/bootstrap-table/tree/master/docs/data/data1/"
       data-show-columns="true">
    <thead>
    <tr>
        <th data-field="name" data-switchable="false">Name</th>
        <th data-field="stargazers_count">Stars</th>
        <th data-field="forks_count">Forks</th>
        <th data-field="description" data-visible="false">Description</th>
    </tr>
    </thead>
</table>

				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!--  Search bar ----------------------------------------------------------- -->
						<jsp:include page="../includes/template/searchNav.jsp" />
						<!--  Search bar ----------------------------------------------------------- -->

						<!--  New Employee buttons ----------------------------------------------------------- -->
						<div class="row">
							<div class="col-md-4">
								<p>
									<a href="addDepartment">
										<button type="button" class="btn btn-success">
											<i class="fa fa-user-plus"></i> Add Department
										</button>
									</a> <a href="fillDepartment">
										<button type="button" class="btn btn-success">Test:
											Fill</button>
									</a>

								</p>
							</div>
						</div>

						<table data-toggle="table" class="table table-striped">
							<thead>
								<tr>
									<th data-sortable="true" class="col-md-1">Shortcut</th>
									<th data-sortable="true">Name</th>
									<th data-sortable="true">Manager</th>
									<th class="col-md-2">Actions</th>
								</tr>
							</thead>
							<tbody>
								<!--  list all employees ----------------------------------------------------------- -->
								<c:forEach items="${departmentList}" var="department">
									<tr>
										<td>${department.shortcut}</td>
										<td>${department.name}</td>
										<td>${department.manager.firstName}
											${department.manager.lastName}</td>
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
		</div>


	</div>
	<!--  End of container -->

	<%-- 	<jsp:include page="../includes/bootstrapJs.jsp" /> --%>
</body>
</html>
