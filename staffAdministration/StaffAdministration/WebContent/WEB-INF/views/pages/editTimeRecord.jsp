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
<title>Edit TimeRecord</title>
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


		<div id="page-wrapper-subpages">
			<div id="page-inner-subpages">

				<!--  add or edit?  ----------------------------------------------------------- -->
				<c:choose>
					<c:when test="${not empty timeRecord}">
						<c:set var="legend">Change Timerecord:</c:set>
						<c:set var="formAction">changeTimeRecord</c:set>
					</c:when>
					<c:otherwise>
						<c:set var="legend">New Timerecord ${employee.firstName} ${employee.lastName}</c:set>
						<c:set var="formAction">addTimeRecord</c:set>
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
								<%-- 		<input type="hidden" name="id" value="${employee.id }" /> --%>

								<! ----------------  startDate ---------------- -->
								<div class="form-group">
									<label for="inputStartDate" class="col-md-2 control-label">Date
										from</label>
									<div class="col-md-5">
										<input class="form_datetime form-control" id="inputStartDate"
											placeholder="Date" type="text" readonly name="startDate"
											value="<fmt:formatDate value="${timeRecord.startDate}" pattern="dd.MM.yyyy"/>"
											required />
									</div>
								</div>

								<! ----------------  endDate ---------------- -->
								<div class="form-group">
									<label for="inputEndDate" class="col-md-2 control-label">Date
										to</label>
									<div class="col-md-5">
										<input class="form_datetime form-control" id="inputEndDate"
											placeholder="Date" type="text" readonly name="endDate"
											value="<fmt:formatDate value="${timeRecord.endDate}" pattern="dd.MM.yyyy"/>"
											required />
									</div>
								</div>

								<!-- Datetime -->
								<%-- <jsp:include page="../includes/template/dateTimePicker.jsp" /> --%>

								<! ----------------  startTime ---------------- -->
								<div class="form-group">
									<label for="inputStartTime" class="col-md-2 control-label">Time
										from</label>
									<div class="col-md-5">
										<input class="form-control" id="inputStartTime" type="text"
											name="startTime" placeholder="hh:mm"
											value="<c:out value="${timeRecord.startTime}"/>" required>
									</div>
								</div>

								<! ----------------  endTime ---------------- -->
								<div class="form-group">
									<label for="inputEndTime" class="col-md-2 control-label">Time
										to</label>
									<div class="col-md-5">
										<input class="form-control" id="inputEndTime" type="text"
											name="endTime" placeholder="hh:mm"
											value="<c:out value="${timeRecord.endTime}"/>" required>
									</div>
								</div>


								<! ---------------  Typ ---------------- -->
								<div class="form-group">
									<label for="inputTyp" class="col-md-2 control-label">Typ</label>
									<div class="col-md-5">
										<select class="form-control" name="typ">
											<option value="working time" selected="selected">working
												time</option>
											<option value="sick leave">sick leave</option>
											<option value="vacation">vacation</option>
										</select>
									</div>
								</div>

								<%-- <! ----------------  Employee For testing Remove ---------------- -->
								<div class="form-group">
									<label for="inputManager" class="col-md-2 control-label">Employee</label>
									<div class="col-md-5">
										<select class="form-control" name="employee">
											<c:forEach items="${employeeList }" var="employee">
												<option value="${employee.id}">${ employee.firstName}
													${employee.lastName }</option>
											</c:forEach>
										</select>
									</div>
								</div> --%>

								<! ----------------  buttons ---------------- -->
								<div class="form-group">
									<div class="col-md-10 col-md-offset-2">
										<button type="Submit" class="btn btn-primary">Submit</button>
										<a href="start">
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

	<!-- Footer -->
	<%-- 	<jsp:include page="../includes/template/fixedFooter.jsp" /> --%>

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
