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
<title>Timerecord</title>
<jsp:include page="../includes/bootstrapCss.jsp" />
</head>
<body>


	<div class="container" role="main">

		<div class="page-header">
			<h1>Timerecords ${employee.firstName} ${employee.lastName}</h1>
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
					<a href="newTimeRecord">
						<button type="button" class="btn btn-success">Add new
							Timerecord</button>
					</a>
				</p>
				<label for="inputManager" class="col-md-2 control-label">Employee</label>
				<form class="form-horizontal" method="post"
					action="timeRecordEmployee">
					<div class="col-md-10">
						<select class="form-control" name="employee">
							<c:forEach items="${employeeList }" var="employee">
								<option value="${employee.id}">${ employee.firstName}
									${employee.lastName }</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-md-offset-2">
							<button type="Submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
				<!-- </a> <a href="fillDepartment">
						<button type="button" class="btn btn-success">Test: Fill</button>
					 -->

			</div>
		</div>
		<!--  New Employee buttons ----------------------------------------------------------- -->


		<div class="row">
			<div class="col-md-10 col-md-offset-1">

				<table data-toggle="table" class="table table-striped">
					<thead>
						<tr>
							<th data-sortable="true">Date From</th>
							<th data-sortable="true">Date To</th>
							<th data-sortable="true">Time From</th>
							<th data-sortable="true">Time To</th>
							<th data-sortable="true">Typ</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--  list all employees ----------------------------------------------------------- -->
						<c:forEach items="${timeRecordList}" var="timeRecord">
							<tr>
								<td>${timeRecord.startDate}</td>
								<td>${timeRecord.endDate}</td>
								<td>${timeRecord.startTime}</td>
								<td>${timeRecord.endTime}</td>
								<td>${timeRecord.typ}</td>
								<td><a href="changeDepartment?id=${timeRecord.id}">
										<button type="button" class="btn btn-xs btn-success">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Edit
										</button>
								</a> <a href="deleteDepartment?id=${timeRecord.id}">
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