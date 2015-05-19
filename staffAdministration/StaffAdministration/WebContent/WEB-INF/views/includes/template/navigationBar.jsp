<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">

			<li><a class="" href="./"><i class="fa fa-dashboard"></i>
					Dashboard</a></li>

			<li><a href="#"><i class="fa fa-user"></i> Personal Area<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="">
					<li><a href="#"><i class="fa fa-user"></i>My Profile</a></li>
					<!-- 					<li><a href="#"><i class="fa fa-wrench"></i>My Account</a></li> -->
					<li class="active"><a href="#"><i
							class="fa fa-info-circle"></i>Set Status<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level collapse in" aria-expanded="true"
							style="">
							<li><a href="#"><i class="fa fa-check-circle"
									style="color: green"></i>Available</a></li>
							<li><a href="#"><i class="fa fa-circle-o"
									style="color: yellow"></i>Busy</a></li>
							<li><a href="#"><i class="fa fa-times-circle"
									style="color: #d9534f"></i>Not available</a></li>

						</ul></li>
				</ul></li>
			<li><a href="#"> <i class="fa fa-university"></i>Business
					Area<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="">
					<li><a href="#"><i class="fa fa-users"></i>All Employees</a></li>
					<li><a href="manageEmployees"><i class="fa fa-sitemap"></i>Manage
							Employees</a></li>
					<li><a href="manageDepartments"><i
							class="fa fa-university"></i>Manage Departments</a></li>
				</ul></li>
			<li><a href="#"><i class="fa fa-clock-o"></i> Time Records<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse" aria-expanded="false"
					style="">
					<li><a href="newTimeRecord"><i class="fa fa-clock-o"></i>New
							Time Record</a></li>
					<li><a href="showPersonalTimeRecords"><i
							class="fa fa-area-chart"></i>My Time Records</a></li>
					<li><a href="showAllTimeRecords"><i
							class="fa fa-area-chart"></i>All Time Records</a></li>
				</ul></li>
			<li data-toggle="modal" data-target="#announcementModal"><a
				href="#"><i class="fa fa-comments"></i> Announcements<span
					class="badge pull-right">5</span></a></li>
			<li><a href="#"><i class="fa fa-calendar"></i> Calendar</a></li>
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
