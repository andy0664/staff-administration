<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="true" %> --%>
<nav class="navbar navbar-default top-navbar" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".sidebar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="./"><b>HR</b>INSIDE</a>
	</div>

	<ul class="nav navbar-top-links pull-right">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <c:choose>
					<c:when test="${sessionScope.status=='Available'}">
						<div style="color: #449D44">
							<i class="fa fa-check-circle" style="margin-right: 5px"></i><i
								class="fa fa-caret-down"></i>
						</div>
					</c:when>
					<c:when test="${sessionScope.status=='Busy'}">
						<div style="color: #F0AD4E">
							<i class="fa fa-circle-o" style="margin-right: 5px"></i><i
								class="fa fa-caret-down"></i>
						</div>
					</c:when>
					<c:when test="${sessionScope.status=='Not available'}">
						<div style="color: #C9302C">
							<i class="fa fa-times-circle" style="margin-right: 5px"></i><i
								class="fa fa-caret-down"></i>
						</div>
					</c:when>
					<c:otherwise>
						<div style="color: #449D44">
							<i class="fa fa-check-circle" style="margin-right: 5px"></i><i
								class="fa fa-caret-down"></i>
						</div>
					</c:otherwise>
				</c:choose>
		</a>
			<ul class="dropdown-menu dropdown-alerts">
				<li><a href="#">
						<div>
							<button type="Submit" class="btn btn-success"
								style="width: 130px" name="status" value="Available">
								<i class="fa fa-check-circle"></i> Available
							</button>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<button type="Submit" class="btn btn-warning"
								style="width: 130px" name="status" value="Busy">
								<i class="fa fa-circle-o"></i> Busy
							</button>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<button type="Submit" class="btn btn-danger" style="width: 130px"
								name="status" value="Not available">
								<i class="fa fa-times-circle"></i> Not available
							</button>
						</div>
				</a></li>
			</ul> <!-- /.dropdown-alerts --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" aria-expanded="false"> <i
				class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<!--                         <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a> -->
				<!--                         </li> -->
				<li><a href="changePassword"><i class="fa fa-gear fa-fw"></i>
						Change Password</a></li>

				<li class="divider">
				<li><c:url value="/logout" var="logoutUrl" />
					<form class="logout-form" action="${ logoutUrl}" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token }" /> <i class="fa fa-sign-out fa-fw">
						</i> <input class="btn btn-xs btn-default logout-button" type="submit"
							value="Logout" />
					</form></li></li>
		<!--  <li> <a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a> 
                        </li> -->
	</ul>
	<!-- /.dropdown-user -->
	</li>
	<!-- /.dropdown -->
	</ul>
</nav>