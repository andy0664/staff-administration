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

<!-- Include Modernizr in the head, before any other Javascript -->
<script src="includes/js/modernizr-2.6.2.min.js"></script>
</head>
<body>
	<!--  Search bar ----------------------------------------------------------- -->
	<jsp:include page="includes/searchNav.jsp" />
	<!--  Search bar ----------------------------------------------------------- -->
	<div class="container" id="main">


		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
		<div class="row" id="featuresHeading">
			<div class="col-12">
				<h2>Features</h2>
				<p class="lead">There you can find all relevant areas</p>
			</div>
			<!-- end col-12 -->
		</div>
		<!-- end featuresHeading -->

		<div class="row-fluid" id="features">
			<div class="col-md-3 feature">
				<div class="panel-default">
					<div class="panel-heading">
						<div class="panel-title">
							<h3>Personal area</h3>
						</div>

						<img src="badge_html5.jpg" class="img-rounded">

						<div class="list-group">
							<a href="manageEmployees" class="list-group-item">
								<h4 class="list-group-item-heading">Manage Employees</h4>
								<p class="list-group-item-text">This is the area where you
									can mangage your employees.</p>
							</a> <a href="manageDepartments" class="list-group-item">
								<h4 class="list-group-item-heading">Manage Departments</h4>
								<p class="list-group-item-text">This is the area where you
									can mangage your departments.</p>
							</a>
						</div>

					</div>
					<!-- end panel-heading -->

					<!-- list-group -->
				</div>

				<!-- end panel -->
			</div>
			<!-- end feature -->

			<div class="col-md-3 feature">
				<div class="my-inner">
					<div class="panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Business area</h3>
						</div>
						<!-- end panel-heading -->
						<img src="badge_css3.jpg" alt="CSS3" class="img-rounded">

						<p>90's authentic single-origin coffee stumptown Pinterest.
							Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>

						<a href="https://www.udemy.com/build-beautiful-html5-website/"
							target="_blank" class="btn btn-danger btn-block">Style it up
							with CSS3</a>
					</div>
				</div>
				<!-- end panel -->
			</div>
			<!-- end feature -->
			<div class="col-md-3 feature">

				<div class="panel-default">
					<div class="panel-heading">
						<div class="panel-title">
							<h3>Time record</h3>
						</div>
						<div class="panel-body">
							<!-- end panel-heading -->
							<img src="badge_bootstrap.jpg" alt="CSS3" class="img-rounded">

							<p>90's authentic single-origin coffee stumptown Pinterest.
								Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>

							<a href="https://www.udemy.com/build-beautiful-html5-website/"
								target="_blank" class="btn btn-danger btn-block">Style it up
								with CSS3</a>
						</div>
					</div>

				</div>

				<!-- end panel -->
			</div>
			<!-- end feature -->
			<div class="col-md-3 feature">
				<div class="my-inner">
					<div class="panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Calendar</h3>
						</div>
						<!-- end panel-heading -->
						<img src="badge_css3.jpg" alt="CSS3" class="img-rounded">

						<p>90's authentic single-origin coffee stumptown Pinterest.
							Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>

						<a href="https://www.udemy.com/build-beautiful-html5-website/"
							target="_blank" class="btn btn-danger btn-block">Style it up
							with CSS3</a>
					</div>
				</div>
				<!-- end panel -->
			</div>
			<!-- end feature -->
		</div>
		<!-- end features -->

	</div>

	<jsp:include page="includes/footer.jsp" />


	<jsp:include page="includes/bootstrapJs.jsp" />
</body>
</html>
