<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../includes/bootstrapMeta.jsp" />
<title>Edit Department</title>
<jsp:include page="../includes/bootstrapCss.jsp" />
</head>
<body>
	<div class="container" role="main">

		<!--  add or edit?  ----------------------------------------------------------- -->
		<c:choose>
			<c:when test="${not empty department}">
				<c:set var="legend">Change Department: ${department.name}</c:set>
				<c:set var="formAction">changeDepartment</c:set>
			</c:when>
			<c:otherwise>
				<c:set var="legend">New Department</c:set>
				<c:set var="formAction">addDepartment</c:set>
			</c:otherwise>
		</c:choose>
		<!--  add or edit?  ----------------------------------------------------------- -->

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form class="form-horizontal" method="post" action="${formAction}">
					<%-- <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }" /> --%>
					<fieldset>
						<legend>${legend}</legend>
						<input type="hidden" name="id" value="${department.id }" />

						<! ----------------  name ---------------- -->
						<div class="form-group.required">
							<label for="inputName" class="col-md-2 control-label">Name</label>
							<div class="col-md-10">
								<input class="form-control" id="inputName" type="text"
									name="name" value="<c:out value="${department.name}"/>">
							</div>
						</div>

						<! ----------------  shortcut ---------------- -->
						<div class="form-group">
							<label for="inputShortcut" class="col-md-2 control-label">Shortcut</label>
							<div class="col-md-10">
								<input class="form-control" id="inputShortcut" type="text" maxlength="5"
									name="shortcut" value="<c:out value="${department.shortcut}"/>">
							</div>
						</div>

						<! ----------------  buttons ---------------- -->
						<div class="form-group">
							<div class="col-md-10 col-md-offset-2">
								<button type="Submit" class="btn btn-primary">Submit</button>
								<a href="manageDepartments">
									<button type="button" class="btn btn-default">Cancel</button>
								</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
	<!--  End of container -->


	<!-- JS for Bootstrap -->
	<%@include file="../includes/bootstrapJs.jsp"%>
	<!-- JS for Bootstrap -->
</body>
</html>