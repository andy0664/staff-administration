<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="../includes/bootstrapMeta.jsp" />
<jsp:include page="../includes/bootstrapCss.jsp" />
<jsp:include page="../includes/bootstrapCalendarCss.jsp" />
<jsp:include page="../includes/bootstrapJs.jsp" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>Spring MVC - ${title}</title>
<script>
	function resize() {
		var menu = document.getElementById("menu");
		var header = document.getElementById("header");
		var content = document.getElementById("content");
		var container = document.getElementById("scheduler");
		content.style.width = (document.body.offsetWidth - menu.offsetWidth)
				+ "px";
		var height = document.body.offsetHeight - header.offsetHeight + 11;
		content.style.height = height + "px";
		container.style.height = (height - 150) + "px";

		if (scheduler)
			scheduler.setCurrentView();
	};
	window.onload = resize;
	window.onresize = resize;
</script>

</head>
<body>
	<div class="header" id="header">
	
		<!--  Navbar Top ----------------------------------------------------------- -->
				<jsp:include page="../includes/template/navbarTopCalendar.jsp" />
	</div>