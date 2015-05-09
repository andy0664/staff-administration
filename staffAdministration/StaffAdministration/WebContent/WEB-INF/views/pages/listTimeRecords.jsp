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
<jsp:include page="../includes/bootstrapJs.jsp" />
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

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="page-header page-header-hr" style="height: 100px">
					<div class="container" role="main">
						<h1>Timerecords ${employee.firstName} ${employee.lastName}</h1>
					</div>
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

				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<p>
							<a href="newTimeRecord">
								<button type="button" class="btn btn-success">Add new
									Timerecord</button>
							</a>
						</p>

						<!-- <form class="form-horizontal" method="post"
							action="timeRecordEmployee"> -->
						<form class="form-horizontal" method="post">
							<%-- <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token }" /> --%>
							<! ----------------  Choose Employee ---------------- -->
							<div class="form-group">
								<label for="inputManager" class="col-md-2 control-label">Employee</label>
								<div class="col-md-7">
									<select class="form-control" name="employee">
										<c:forEach items="${employeeList }" var="employee">
											<option value="${employee.id}">${ employee.firstName}
												${employee.lastName }</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<! ----------------  DateFrom ---------------- -->
							<div class="form-group">
								<label for="inputDate" class="col-md-2 control-label">From</label>
								<div class="col-md-7">
									<input class="form_datetime form-control" id="inputDateFrom"
										placeholder="Date" type="text" readonly name="dateFrom"
										value="<fmt:formatDate value="${dateFrom}" pattern="dd.MM.yyyy"/>" />
								</div>
							</div>

							<! ----------------  DateTo ---------------- -->
							<div class="form-group">
								<label for="inputDate" class="col-md-2 control-label">To</label>
								<div class="col-md-7">
									<input class="form_datetime form-control" id="inputDateFrom"
										placeholder="Date" type="text" readonly name="dateTo"
										value="<fmt:formatDate value="${dateTo}" pattern="dd.MM.yyyy"/>" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-2">
									<button type="Submit" class="btn btn-primary" formaction="timeRecordEmployee">Show</button>
									<button type="Submit" class="btn btn-primary" formaction="timeRecordExcelExport">Export</button>
								</div>
							</div>
						</a>
						</form>
						<!-- </a> <a href="fillDepartment">
						<button type="button" class="btn btn-success">Test: Fill</button>
					 -->
						<!-- <a href="timeRecordExcelExport">
							<button type="button" class="btn btn-xs btn-success">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								Excel Export
							</button>
						</a> -->
					</div>
				</div>
				<!--  New Employee buttons ----------------------------------------------------------- -->


				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<a href="timeRecordExcelExport">
							<button type="button" class="btn btn-xs btn-success pull-right" style="margin-bottom:5px">
								<i class="fa fa-table"></i>
								Excel Export
							</button>
						</a>
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

										<td><fmt:formatDate value="${timeRecord.startDate}"
												pattern="dd.MM.yyyy" /></td>
										<td><fmt:formatDate value="${timeRecord.endDate}"
												pattern="dd.MM.yyyy" /></td>
										<td>${timeRecord.startTime}</td>
										<td>${timeRecord.endTime}</td>
										<td>${timeRecord.typ}</td>
										<td><a
											href="deleteTimeRecord?timerecord=${timeRecord.id}&id=${employee.id}&dateFrom=<fmt:formatDate value="${dateFrom}" pattern="dd.MM.yyyy"/>&dateTo=<fmt:formatDate value="${dateTo}" pattern="dd.MM.yyyy"/>">
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





	<!-- Footer -->
	<jsp:include page="../includes/template/fixedFooter.jsp" />

	<jsp:include page="../includes/bootstrapJs.jsp" />

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
