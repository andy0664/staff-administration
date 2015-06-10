<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">

			<li><a class="" href="../"><i class="fa fa-dashboard"></i>
					Dashboard</a></li>

			<li><a href="showProfile"><i class="fa fa-user"></i> My
					Profile</a></li>
			<li><a href="#"> <i class="fa fa-building-o"></i> Business
					Area<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="">
					<li><a href="#"><i class="fa fa-users"></i>All Employees</a></li>
					<sec:authorize access="hasAnyRole('ADMIN','MANAGER')">
						<li><a href="manageEmployees"><i class="fa fa-sitemap"></i>Manage
								Employees</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="manageDepartments"><i
								class="fa fa-university"></i>Manage Departments</a></li>
					</sec:authorize>
				</ul></li>
			<li><a href="../showEmployees"><i class="fa fa-clock-o"></i> Time Records<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="">
					<li><a href="../newTimeRecord"><i class="fa fa-clock-o"></i>New
							Time Record</a></li>
					<li><a href="../showPersonalTimeRecords"><i
							class="fa fa-list-ul"></i>My Time Records</a></li>
					<sec:authorize access="hasAnyRole('ADMIN','MANAGER')">
						<li><a href="../showAllTimeRecords"><i
								class="fa fa-database"></i>All Time Records</a></li>
					</sec:authorize>
				</ul></li>
			<sec:authorize access="hasAnyRole('ADMIN','MANAGER')">
				<li data-toggle="modal" data-target="#announcementModal"><a
					href="#"><i class="fa fa-comments"></i> Announcements<span
						class="badge pull-right">${fn:length(announcementList)}</span></a></li>
			</sec:authorize>
			<li><a href="./showCalendarPersonal"><i
					class="fa fa-calendar"></i>My Calendar</a></li>
		</ul>
	</div>
</nav>

<!-- Modal News-->
<jsp:include page="../template/modalAnnouncements.jsp" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/metisMenu/2.0.0/metisMenu.js"></script>
<script>
	$(function() {
		$('#main-menu').metisMenu();
	});
</script>
