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
					<h1>All Employees</h1>
				</div>
				<!--  Error message ----------------------------------------------------------- -->
				<%-- <c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if> --%>
				<!--  Error message ----------------------------------------------------------- -->

				<%-- <!--  Warning message ----------------------------------------------------------- -->
		<c:if test="${not empty warningMessage}">
			<div class="alert alert-warning" role="warning">
				${warningMessage}</div>
		</c:if>
		<!--  Warning message ----------------------------------------------------------- --> --%>

				<!--   message ----------------------------------------------------------- -->
				<%-- <c:if test="${not empty updateEmployeeMessage}">
					<div class="alert alert-success" role="warning">${message}</div>
				</c:if> --%>
				<!--   message ----------------------------------------------------------- -->

				<div class="row">
					<div class="col-md-12">
						<table data-toggle="table" class="table table-striped"
							data-sort-name="name" data-sort-order="desc"
							data-url="/gh/get/response.json/wenzhixin/bootstrap-table/tree/master/docs/data/data1/"
							data-show-columns="true" data-search="true"
							data-toolbar="#toolbar" data-height="755">
							<thead>
								<tr>
									<th data-sortable="true">First Name</th>
									<th data-sortable="true">Last Name</th>
									<th data-sortable="true">Department</th>
									<th data-sortable="true">Job Description</th>
									<th data-sortable="true">E-Mail</th>
									<th data-sortable="true">Telephone</th>
									<th data-sortable="true">Status</th>
									<th>Calendar</th>
								</tr>
							</thead>
							<tbody>
								<!--  list all employees ----------------------------------------------------------- -->
								<c:forEach items="${employeeList}" var="employee">
									<tr>
										<td>${employee.firstName}</td>
										<td>${employee.lastName}</td>
										<td>${employee.department.name}</td>
										<td>${employee.jobDescription}</td>
										<td>${employee.mail}</td>
										<td>${employee.phone}</td>
										<td><c:choose>
												<c:when test="${employee.status=='Available'}">
													<div style="color: #449D44">
														<i class="fa fa-check-circle" style="margin-right: 5px"></i>${employee.status}</div>
												</c:when>
												<c:when test="${employee.status=='Busy'}">
													<div style="color: #F0AD4E">
														<i class="fa fa-circle-o" style="margin-right: 5px"></i>${employee.status}</div>
												</c:when>
												<c:when test="${employee.status=='Not available'}">
													<div style="color: #C9302C">
														<i class="fa fa-times-circle" style="margin-right: 5px"></i>${employee.status}</div>
												</c:when>
											</c:choose></td>
										<td><a
											href="calendar/showCalendarReadOnly?username=${employee.userName}">
												<button type="button" class="btn btn-xs btn-primary">
													<i class="fa fa-calendar" style="margin-right: 5px"></i>
													View Calendar
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
</body>
</html>
