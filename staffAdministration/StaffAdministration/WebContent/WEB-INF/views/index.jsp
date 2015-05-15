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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/metisMenu/2.0.0/metisMenu.js"></script>

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


	<%-- 	<jsp:include page="includes/template/dateTimePicker.jsp" /> --%>

	<div id="wrapper">
		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="includes/template/navigationBar.jsp" />


		<div id="page-wrapper">
			<div id="page-inner">
				<script type="text/javascript">
					$('#timepicker1').timepicker();
				</script>
				<%-- 		<jsp:include page="includes/template/dateTimePicker.jsp" /> --%>
				<div class="page-header" style="margin-left: 15px">
					<h1>
						Welcome to <b style="color: #2DAFCB">HR</b><b>INSIDE</b>
					</h1>
				</div>

				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
				<!-- end featuresHeading -->

				<div class="row-fluid" id="features">
					<div class="col-md-4">

						<a href="#">
							<div class="panel panel-blue">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-user fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">My Profile</font>
										<div>View your own profile!</div>
									</div>
								</div>
							</div>
						</a> <a href="#">
							<div class="panel panel-blue" data-toggle="collapse"
								data-target="#collapseExample">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-info-circle fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">Set Status</font>
										<div>Set your current status</div>
									</div>
								</div>
								<div class="collapse " id="collapseExample">
									<div class="status-field">
										<div class="row status-buttons">
											<button type="button" class="btn btn-success"
												style="width: 130px">
												<i class="fa fa-check-circle"></i> Available
											</button>
											<button type="button" class="btn btn-warning"
												style="width: 130px">
												<i class="fa fa-circle-o"></i> Busy
											</button>
											<button type="button" class="btn btn-danger"
												style="width: 130px">
												<i class="fa fa-times-circle"></i> Not available
											</button>
										</div>
									</div>
								</div>
							</div>
						</a>
						<!-- 						<a href="#"> -->
						<!-- 							<div class="panel panel-blue"> -->
						<!-- 								<div class="row"> -->
						<!-- 									<div class="col-xs-3"> -->
						<!-- 										<i class="fa fa-wrench fa-5x"></i> -->
						<!-- 									</div> -->
						<!-- 									<div class="col-xs-9 text-right"> -->
						<!-- 										<font size="5">My Account</font> -->
						<!-- 										<div>Settings for your Account</div> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</a> -->

						<!-- end panel -->

						<!-- end feature -->


						<a href="#">
							<div class="panel panel-red">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-users fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">All Employees</font>
										<div>Get a list of all employees</div>
									</div>
								</div>
							</div>
						</a> <a href="manageEmployees">
							<div class="panel panel-red">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-sitemap fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">Manage Employees</font>
										<div>Add, edit or remove employees</div>
									</div>
								</div>
							</div>
						</a> <a href="manageDepartments">
							<div class="panel panel-red">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-university fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">Manage Departments</font>
										<div>Add, edit or remove departments</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<!-- end panel -->
				</div>


				<div class="row-fluid" id="features">
					<!-- end feature -->
					<div class="col-md-4 feature">

						<!-- Announcements -->
						<a href="#">
							<div class="panel panel-violet" data-toggle="modal"
								data-target="#announcementModal">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-comments fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="6">25</font>
										<div>
											<font size="3">Announcements</font>
										</div>
									</div>
								</div>
							</div>
						</a>
						<!-- 			Time Records -->
						<a href="newTimeRecord">
							<div class="panel panel-green">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-clock-o fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">New Time Record</font>
										<div>Create a new Time Record</div>
									</div>
								</div>
							</div>
						</a> <a href="showPersonalTimeRecords">
							<div class="panel panel-green">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-area-chart fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">My Time Records</font>
										<div>Get a statistic of your Time Records</div>
									</div>
								</div>
							</div>
						</a> <a href="showAllTimeRecords">
							<div class="panel panel-green">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-area-chart fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">All Time Records</font>
										<div>Get a statistic of all Time Records</div>
									</div>
								</div>
							</div>
						</a>

						<!-- end panel -->

						<!-- end feature -->


						<!-- Calendar -->

						<a href="manageDepartments">
							<div class="panel panel-yellow" style="height: 102px">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-calendar fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<font size="5">Calendar</font>
										<div>
											View your own Calander and
											<p>the Calendar of your Collegues</p>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					<!-- end panel -->
				</div>

				<div class="col-md-4">
					<!-- News -->
					<div class="panel panel-news">
						<div class="panel-heading">
							<font size="5">News</font> <a href="#">
								<button type="button" class="btn btn-info pull-right"
									id="
									myBtn" data-toggle="modal"
									data-target="#basicModal">New entry</button>
							</a>
						</div>
						<div class="panel-body">
							<c:forEach items="${newsList }" var="news">
								<div class="row">
									<div class="col-xs-12 news-item">
										<div class="col-xs-3" style="margin-left: -15px">
											<i class="fa fa-newspaper-o fa-5x" style="color: #708090"></i>
										</div>
										<div class="col-xs-8" style="margin-left: -15px">
											<b>${news.title}</b>
											<p>${news.message}</p>
										</div>
										<div class="col-xs-1">
											<a href="removeNews?id=${news.id}">
												<button type="button" class="btn btn-xs btn-danger">
													<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>delete
												</button>
											</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<!-- 						<div class="panel-footer footer-news"> -->
						<!-- 							<a href="#"> -->
						<!-- 								<button type="button" class="btn btn-info "id=" -->
						<!-- 									myBtn" -->
						<!-- 									data-toggle="modal" data-target="#basicModal">New -->
						<!-- 									entry</button> -->
						<!-- 							</a> -->
						<!-- 						</div> -->
					</div>
				</div>
				<!-- end feature -->
			</div>
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
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token }" />
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

		<!-- Modal Announcements -->
		<div class="modal fade" id="announcementModal" role="dialog"
			aria-labelledby="announcementModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Announcements</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-anncouncement">
							<div class="panel-heading">
								<div class="row" style="margin-right: 0px; margin-left: 0px">
									<font size="5">Karin Steinberger</font>
									<button type="button" class="btn pull-right btn-danger"
										style="width: 80px">Deny</button>
									<button type="button" class="btn pull-right btn-success"
										style="margin-right: 15px; width: 80px">Accept</button>
								</div>
								<p>Vacation Request</p>
							</div>
							<div class="panel-body">
								<h3>
									<i class="fa fa-arrow-circle-o-right"
										style="margin-right: 5px; color: grey"></i>25.04.2015
								</h3>
								<h3>
									06.05.2015<i class="fa fa-arrow-circle-o-left"
										style="margin-left: 5px; color: grey"></i>
								</h3>
							</div>
						</div>

						<div class="panel panel-anncouncement">
							<div class="panel-heading">
								<div class="row" style="margin-right: 0px; margin-left: 0px">
									<font size="5"><i class="fa fa-birthday-cake"
										style="margin-right: 5px"></i>Birthday!!</font>
									<button type="button" class="btn pull-right btn-success"
										style="width: 60px; background-color: transparent; border: 0px">
										<i class="fa fa-check-circle-o fa-2x"></i>
									</button>
								</div>
							</div>
							<div class="panel-body">
								<h3>Markus Oberhauser</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<%-- 	<jsp:include page="includes/template/footer.jsp" /> --%>

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
