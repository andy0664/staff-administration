<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="includes/bootstrapMeta.jsp" />
<title>Staff Administration</title>
<jsp:include page="includes/bootstrapCss.jsp" />
</head>
<body>
	<center>
		<h1>Welcome!!!!</h1>
		<div class="cotainer" role="main">
			<div class="row">
				<div class="col-sm-4 col-md-offset-1"
					style="background-color: aqua;">Personal area</div>
				<div class="col-sm-4 col-md-offset-2"
					style="background-color: orange;">
					Business area
					<p>
						<a href="addEmployee">
							<button type="button" class="btn btn-success">Add new
								Employee</button>
						</a>
					<p>
						<a href="addDepartment">
							<button type="button" class="btn btn-success">Add new
								Department</button>
						</a>
				</div>
				<div class="col-sm-4 col-md-offset-1"
					style="background-color: yellow;">Time record</div>
				<div class="col-sm-4 col-md-offset-2"
					style="background-color: gray;">Calendar</div>
			</div>
		</div>
	</center>



	<jsp:include page="includes/bootstrapJs.jsp" />
</body>
</html>
