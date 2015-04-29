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
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
		<div class="cotainer" role="main">
			<div class="row">
				<div class="col-sm-4 col-md-offset-1"
					style="background-color: aqua;">Personal area</div>
				<div class="col-sm-4 col-md-offset-2"
					style="background-color: orange;">
					Business area
					<p>
						<a href="manageEmployee">
							<button type="button" class="btn btn-success">Manage
								Employees</button>
						</a>
					<p>
						<a href="manageDepartment">
							<button type="button" class="btn btn-success">Manage
								Departments</button>
						</a>
				</div>
				<div class="col-sm-4 col-md-offset-1"
					style="background-color: yellow;">Time record</div>
				<div class="col-sm-4 col-md-offset-2"
					style="background-color: gray;">Calendar</div>
			</div>
		</div>

		<footer class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<h6>Copyright &copy; 2015 FH JOANNEUM</h6>
					</div>
					<!-- end col-sm-2 -->

					<div class="col-sm-4">
						<h6>About Us</h6>
						<p>Wir sind die Coolsten, wenn wir cruisen, Wenn wir durch die
							City düsen, Wir sind die Coolsten, wenn die süßen Ladies uns mit
							Küsschen grüssen. Wir sind die Coolsten, wenn wir cruisen, Wenn
							wir durch die City düsen, Wir sind die Coolsten, nie am loosen
							weil wir rulen, wenn wir cruisen.</p>
					</div>
					<!-- end col-sm-4 -->

					<div class="col-sm-2">
						<h6>Navigation</h6>
						<ul class="unstyled">
							<li><a href="#">Home</a></li>
							<li><a href="#">Services</a></li>
							<li><a href="#">Links</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
					</div>
					<!-- end col-sm-2 -->

					<div class="col-sm-2">
						<h6>Follow Us</h6>
						<ul class="unstyled">
							<li><a href="#">Twitter</a></li>
							<li><a href="#">Facebook</a></li>
							<li><a href="#">Google Plus</a></li>
						</ul>
					</div>
					<!-- end col-sm-2 -->

					<div class="col-sm-2">
						<h6>
							Coded by Hannes Hopfer, Andreas Gratzl, Simon Eicher
						</h6>
					</div>
					<!-- end col-sm-2 -->
				</div>
				<!-- end row -->
			</div>
			<!-- end container -->
		</footer>
	</center>



	<jsp:include page="includes/bootstrapJs.jsp" />
</body>
</html>
