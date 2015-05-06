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
<jsp:include page="includes/bootstrapJs.jsp" />

<!-- Include Modernizr in the head, before any other Javascript -->
<script src="includes/js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- DateTimePicker -->
<script type="text/javascript"
	src="/bower_components/moment/min/moment.min.js"></script>

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script
	src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/src/js/bootstrap-datetimepicker.js"></script>
</head>
<body>



	<!--  Search bar ----------------------------------------------------------- -->
	<jsp:include page="includes/template/navigationBar.jsp" />
	<!--  Search bar ----------------------------------------------------------- -->


	<%-- 	<jsp:include page="includes/template/dateTimePicker.jsp" /> --%>

	<div class="container" id="main">
		<script type="text/javascript">
			$('#timepicker1').timepicker();
		</script>
		<%-- 		<jsp:include page="includes/template/dateTimePicker.jsp" /> --%>
		<div class="row" id="bigCallout">
			<div class="col-12">
				<!-- Visible only on small devices -->
				<div class="well well-small visible-sm">
					<a href="" class="btn btn-large btn-block btn-default"><span
						class="glyphicon glyphicon-phone"></span> Give us a call!</a>
				</div>
				<!-- end well-small -->

				<div class="well">
					<div class="page-header">
						<h1>
							Welcome!<small> Staff Administration is the optimal tool
								for your needs.</small>
						</h1>
					</div>
					<!-- end page-header -->

					<p class="lead">Some solid leading copy will help get your
						users engaged. Use this area to come up with something real nice.</p>

				</div>
				<!-- end well -->

			</div>
			<!-- end col-12 -->
		</div>

		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">${errorMessage}</div>
		</c:if>
		<!-- end featuresHeading -->

		<div class="row-fluid" id="features">

			<div class="col-md-4">

				<div class="panel panel-green">
					<div class="panel-heading">

						<h3 class="panel-title">Personal area</h3>
					</div>
					<!-- end panel-heading -->
					<!-- 					<img src="badge_css3.jpg" alt="CSS3" class="img-rounded"> -->

					<div class="list-group">
						<a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">View Profile</h4>
							<p class="list-group-item-text">See your own prifle Data</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">Account Settings</h4>
							<p class="list-group-item-text">This is the area where you
								can cange your Passwort</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">Set status</h4>
							<p class="list-group-item-text">There you can set your
								current status</p>
						</a>
					</div>


				</div>

				<!-- end panel -->

				<!-- end feature -->


				<div class="panel panel-blue">
					<div class="panel-heading">
						<h3 class="panel-title">Business area</h3>
					</div>
					<!-- end panel-heading -->
					<!-- 					<img src="badge_css3.jpg" alt="CSS3" class="img-rounded"> -->

					<div class="list-group">
						<a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">List all employees</h4>
							<p class="list-group-item-text">This is the area where you
								can list all employees.</p>
						</a> <a href="manageEmployees" class="list-group-item">
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
			</div>

			<!-- end panel -->
		</div>


		<div class="row-fluid" id="features">
			<!-- end feature -->
			<div class="col-md-4 feature">
				<div class="panel panel-red">
					<div class="panel-heading">
						<h3 class="panel-title">Time Record</h3>
					</div>
					<!-- end panel-heading -->
					<!-- 					<img src="badge_css3.jpg" alt="CSS3" class="img-rounded"> -->

					<div class="list-group">
						<a href="newTimeRecord" class="list-group-item">
							<h4 class="list-group-item-heading">create new time record</h4>
							<p class="list-group-item-text">This is the area where you
								can list all employees.</p>
						</a> <a href="showTimeRecords" class="list-group-item">
							<h4 class="list-group-item-heading">personal time statistic</h4>
							<p class="list-group-item-text">This is the area where you
								can mangage your employees.</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">Employee time statistic</h4>
							<p class="list-group-item-text">This is the area where you
								can mangage your departments.</p>
						</a>
					</div>
				</div>

				<!-- end panel -->

				<!-- end feature -->



				<div class="panel panel-yellow">
					<div class="panel-heading">
						<h3 class="panel-title">Calendar</h3>
					</div>
					<!-- end panel-heading -->
					<!-- 					<img src="badge_css3.jpg" alt="CSS3" class="img-rounded"> -->

					<div class="list-group">
						<a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">My calendar</h4>
							<p class="list-group-item-text">This is the area where you
								can list all employees.</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">Shared calendar</h4>
							<p class="list-group-item-text">This is the area where you
								can mangage your employees.</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">Feature events</h4>
							<p class="list-group-item-text">This is the area where you
								can mangage your departments.</p>
						</a>
					</div>
				</div>
			</div>

			<!-- end panel -->
		</div>

		<!-- 		Announcements -->
		<div class="col-md-4">

			<div class="panel panel-announcements">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-comments fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge">26</div>
							<div>New Announcements!</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">View Details</span> <span
							class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>

			<!-- News -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-list-alt"></span><b>News</b>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12">
							<ul class="demo">
								<c:forEach items="${newsList }" var="news">
									<li class="news-item">
										<table cellpadding="4">
											<tr>
												<td><img src="images/1.png" width="60"
													class="img-circle" /></td>
												<td><b>${news.title}</b>
												<p>${news.message}</td>
												<td><a href="removeNews?id=${news.id}">
													<button type="button" class="btn btn-xs btn-danger">delete</button></a></td>
											</tr>
										</table>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<a href="#">
						<button type="button" class="btn btn-primary" id="myBtn"
							data-toggle="modal" data-target="#basicModal">New entry</button>
					</a>
					<ul class="pagination pull-right" style="margin: 0px;">
						<li><a href="#" class="prev"><span
								class="glyphicon glyphicon-chevron-down"></span></a></li>
						<li><a href="#" class="next"><span
								class="glyphicon glyphicon-chevron-up"></span></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- end feature -->
	</div>
	<!-- end features -->

	<!-- Modal -->
	<div class="modal fade" id="basicModal" role="dialog"
		aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">New Entry</h4>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="newNews">
						<div class="form-group">
							<label for="usr">Heading:</label> <input type="text"
								class="form-control" id="inputTitle" name="title">
						</div>
						<div class="form-group">
							<label for="comment">Content</label>
							<textarea class="form-control" rows="5" id="inputMessage"
								name="message"></textarea>
						</div>
						<!-- <div class="form-group">
							<label for="usr">Link:</label> <input type="text"
								class="form-control" id="usr">
						</div> -->
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Save
								changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="includes/template/footer.jsp" />



	<script type="text/javascript">
		$(function() {
			$(".demo1").bootstrapNews({
				newsPerPage : 3,
				autoplay : true,
				pauseOnHover : true,
				direction : 'up',
				newsTickerInterval : 4000,
				onToDo : function() {
					//console.log(this);
				}
			});
		})
	</script>

	<script>
		$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#basicModal").modal({
					backdrop : "static"
				});
			});
		});
	</script>


</body>
</html>
