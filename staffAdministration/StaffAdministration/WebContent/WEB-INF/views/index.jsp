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

</head>
<body>


	<%-- 	<jsp:include page="includes/template/dateTimePicker.jsp" /> --%>

	<div id="wrapper">
		<!--  Navbar Top ----------------------------------------------------------- -->
		<jsp:include page="includes/template/navbarTop.jsp" />

		<!--  Navbar Side ----------------------------------------------------------- -->
		<jsp:include page="includes/template/navigationBar.jsp" />

		<div id="page-wrapper">
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
									<div>view your own profile!</div>
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
									<div>set your current status</div>
								</div>
							</div>
							<div class="collapse " id="collapseExample">
								<form class="form-horizontal" method="post"
									action="setStatus">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token }" />
									<div class="status-field">
										<div class="row status-buttons">
											<button type="Submit" class="btn btn-success"
												style="width: 130px" name="status" value="Available">
												<i class="fa fa-check-circle"></i> Available
											</button>
											<button type="Submit" class="btn btn-warning"
												style="width: 130px" name="status" value="Busy">
												<i class="fa fa-circle-o"></i> Busy
											</button>
											<button type="Submit" class="btn btn-danger"
												style="width: 130px" name="status" value="Not available">
												<i class="fa fa-times-circle"></i> Not available
											</button>
										</div>
									</div>
								</form>
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


					<a href="showEmployees">
						<div class="panel panel-red">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<font size="5">All Employees</font>
									<div>get a list of all employees</div>
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
									<div>add, edit or remove employees</div>
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
									<div>add, edit or remove departments</div>
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
									<div>create a new Time Record</div>
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
									<div>get a statistic of your Time Records</div>
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
									<div>get a statistic of all Time Records</div>
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
										view your own calander and
										<p>the calendar of other employees</p>
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
										<span class="pull-right text-muted"> <em>Today</em>
										</span> <b>${news.title}</b>
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

			<div class="row-fluid">
				<div class="col-md-12">
					<!-- Line Chart -->
					<div class="col-md-8">
						<div class="panel-charts">
							<div id="lineChart" style="width: 100%; height: 400px;"></div>
						</div>
					</div>
					<!-- Pie Chart -->
					<div class="col-md-4">
						<div class="panel-charts">
							<div id="pieChart" style="width: 100%; height: 400px;"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="col-md-12">
					<!-- Bar Chart -->
					<div class="col-md-8">
						<div class="panel-charts">
							<div id="barChart" style="width: 100%; height: 400px;"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- 	Line Chart -->
			<!-- <script>
				$(function() {
					$('#lineChart').highcharts(
							{
								title : {
									text : 'Monthly Average Time Records',
									x : -20
								//center
								},
								xAxis : {
									categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
											'May', 'Jun', 'Jul', 'Aug', 'Sep',
											'Oct', 'Nov', 'Dec' ]
								},
								yAxis : {
									title : {
										text : 'Hours'
									},
									plotLines : [ {
										value : 0,
										width : 1,
										color : '#808080'
									} ]
								},
								legend : {
									layout : 'horizontal',
									align : 'center',
									verticalAlign : 'bottom',
									borderWidth : 0
								},
								series : [
										{
											name : 'Avarage Vacation Hours',
											data : [ 7.0, 6.9, 9.5, 14.5, 18.2,
													21.5, 25.2, 26.5, 23.3,
													18.3, 13.9, 9.6 ],
											color : '#5cb85c'
										},
										{
											name : 'Avarage Working Hours',
											data : [ -0.2, 0.8, 5.7, 11.3,
													17.0, 22.0, 24.8, 24.1,
													20.1, 14.1, 8.6, 2.5 ],
											color : '#337ab7'
										},
										{
											name : 'Avarage Sicness Hours',
											data : [ -0.9, 0.6, 3.5, 8.4, 13.5,
													17.0, 18.6, 17.9, 14.3,
													9.0, 3.9, 1.0 ],
											color : '#d9534f'
										} ]
							});
				});
			</script>

						Pie Chart
			<script>
				$(function() {

					$(document)
							.ready(
									function() {

										// Build the chart
										$('#pieChart')
												.highcharts(
														{
															chart : {
																plotBackgroundColor : null,
																plotBorderWidth : null,
																plotShadow : false
															},
															title : {
																text : 'Employee Distribution by Departments'
															},
															tooltip : {
																pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
															},
															plotOptions : {
																pie : {
																	allowPointSelect : true,
																	cursor : 'pointer',
																	dataLabels : {
																		enabled : false
																	},
																	showInLegend : true
																}
															},
															series : [ {
																type : 'pie',
																name : 'Employees',
																data : [
																		[ 'IT',
																				10 ],
																		[ 'HR',
																				7 ],
																		{
																			name : 'Controlling',
																			y : 12.8,
																			sliced : false,
																			selected : false
																		},
																		[
																				'Logistics',
																				15 ],
																		[
																				'Marketing',
																				6 ], ]
															} ]
														});
									});

				});
			</script>

			<script>
				$(function() {
					$('#barChart')
							.highcharts(
									{
										chart : {
											type : 'column'
										},
										title : {
											text : 'Employee Distribution'
										},
										xAxis : {
											categories : [ 'Marketing', 'IT',
													'HR', 'Logistics',
													'Controlling' ]
										},
										yAxis : {
											min : 0,
											title : {
												text : 'Employees'
											},
											stackLabels : {
												enabled : true,
												style : {
													fontWeight : 'bold',
													color : (Highcharts.theme && Highcharts.theme.textColor)
															|| 'gray'
												}
											}
										},
										legend : {
											align : 'right',
											x : -30,
											verticalAlign : 'top',
											y : 25,
											floating : true,
											backgroundColor : (Highcharts.theme && Highcharts.theme.background2)
													|| 'white',
											borderColor : '#CCC',
											borderWidth : 1,
											shadow : false
										},
										tooltip : {
											formatter : function() {
												return '<b>' + this.x
														+ '</b><br/>'
														+ this.series.name
														+ ': ' + this.y
														+ '<br/>' + 'Total: '
														+ this.point.stackTotal;
											}
										},
										plotOptions : {
											column : {
												stacking : 'normal',
												dataLabels : {
													enabled : true,
													color : (Highcharts.theme && Highcharts.theme.dataLabelsColor)
															|| 'white',
													style : {
														textShadow : '0 0 3px black'
													}
												}
											}
										},
										series : [ {
											name : 'Part-Time',
											data : [ 5, 3, 4, 7, 2 ],
											color : '#5cb85c'
										}, {
											name : 'Full-Time',
											data : [ 3, 4, 4, 2, 5 ],
											color : '#337ab7'
										}, {
											name : 'Marginally',
											data : [ 2, 2, 3, 2, 1 ],
											color : '#d9534f'
										} ]
									});
				});
			</script> -->

		</div>
	</div>
	<!-- end features -->

	<!-- Modal News -->
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

	<!-- Footer -->
	<%-- 	<jsp:include page="includes/template/footer.jsp" /> --%>

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
