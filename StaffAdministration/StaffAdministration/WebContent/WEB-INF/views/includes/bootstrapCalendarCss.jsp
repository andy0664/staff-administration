<!-- Bootstrap core CSS -->
<!-- Latest compiled and minified CSS -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.6.0/bootstrap-table.min.css">

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style type="text/css">
/* Calendar */
#content {
    background-color: #FAF7F0;
    float: left;
    height: 100%;
    width: 100%;
    position: absolute;
    top: 60px;
    left: 260px;
    border-radius: 5px 0px 0px;
    padding: 20px 20px 20px 40px;
    box-sizing: border-box;
}

#menu {
    width: 260px;
    height: 100%;
    float: left;
    background-color: #F0EDE7;
}

html, body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	width: 100%;
	background-color: #faf7f0;
	overflow: hidden;
}

.menu {
	width: 234px;
	height: 100%;
	float: left;
	background-color: #f0ede7;
}

.menu ul {
	padding: 10px 0px;
	margin: 0px;
	background-color: #e4e1db;
}

.menu li {
	list-style-type: none;
	height: 30px;
	background-color: #f0ede7;
	border-bottom: 1px solid #cdcdcd;
}

.menu li a {
	width: 100%;
	height: 100%;
	display: block;
	line-height: 30px;
	padding-left: 10px;
	box-sizing: border-box;
	padding-left: 20px;
	color: #00829d;
	text-decoration: none;
	font-family: Arial;
	font-size: 14px;
}

.menu li a:hover {
	background-image: url("./codebase/demo/menu.png");
	background-repeat: repeat-x;
	background-position: 0px 0px;
	color: #ffffff;
}

.header {
	width: 100%;
	height: 56px;
	background-image: url("./codebase/demo/header.png");
	background-position: 0px 0px;
	background-repeat: repeat-x;
}

.logo {
	background-image: url("./codebase/demo/logo.png");
	background-position: 30px 10px;
	background-repeat: no-repeat;
	width: 250px;
	height: 100%;
}

.content {
	background-color: #faf7f0;
	float: left;
	height: 100%;
	width: 100%;
	position: absolute;
	top: 45px;
	left: 234px;
	webkit-border-radius: 5px 0px 0px 0px;
	border-radius: 5px 0px 0px 0px;
	-webkit-box-shadow: -3px 0px 14px rgba(50, 50, 50, 0.1);
	-moz-box-shadow: -3px 0px 14px rgba(50, 50, 50, 0.1);
	box-shadow: -3px 0px 14px rgba(50, 50, 50, 0.1);
	padding-top: 20px;
	padding-bottom: 20px;
	padding-right: 20px;
	padding-left: 40px;
	box-sizing: border-box;
}

.sample {
	width: 900px;
	height: 90px;
	margin-bottom: 10px;
}

.sample .name {
	width: 32%;
	height: 100%;
	font-family: Arial;
	font-size: 24px;
	color: #a54a4a;
	float: left;
	padding: 4px;
	padding-right: 20px;
	box-sizing: border-box;
	background-image: url("./codebase/demo/delimiter.png");
	background-position: right top;
	background-repeat: no-repeat;
}

.sample .dsc {
	width: 60%;
	height: 100%;
	font-family: Tahoma;
	font-size: 14px;
	color: #464646;
	float: left;
	padding: 4px;
	padding-left: 20px;
	box-sizing: border-box;
}

.scheduler>div {
	border: 1px solid #cecece;
}


/* Navbar */
.top-navbar {
	margin: 0px;
	box-shadow: 0 3px 3px rgba(0, 0, 0, 0.05);
}

.navbar-side {
	z-index: 1;
	width: 260px;
	position: fixed;
	background-color: transparent;
	top: 60px;
}

.top-navbar .navbar-brand {
	color: #fff;
	width: 260px;
	text-align: left;
	height: 60px;
	font-size: 30px;
	font-weight: 700;
	text-transform: uppercase;
	line-height: 30px;
	background: #32323a;
	position: fixed;
}

.navbar-brand b {
	color: #2DAFCB;
}

.top-navbar .nav>li {
	position: relative;
	display: inline-block;
	margin: 0px;
	padding: 0px;
}

.top-navbar .nav>li>a {
	position: relative;
	display: block;
	padding: 20px;
	color: #FFFFFF;
	margin: 0px;
}

.top-navbar .nav>li>a:hover, .top-navbar .nav>li>a:focus {
	text-decoration: none;
	color: #319DB5 !important;
	background: transparent;
}

.top-navbar .dropdown-menu {
	min-width: 230px;
	border-radius: 0 0 4px 4px;
}

.top-navbar .dropdown-menu>li>a:hover, .top-navbar .dropdown-menu>li>a:focus
	{
	color: #225081;
	background: none;
}

.dropdown-tasks {
	width: 255px;
}

.dropdown-tasks .progress {
	height: 8px;
	margin-bottom: 8px;
	overflow: hidden;
	background-color: #f5f5f5;
	border-radius: 0px;
}

.dropdown-tasks>li>a {
	padding: 0px 15px;
}

.dropdown-tasks p {
	font-size: 13px;
	line-height: 21px;
	padding-top: 4px;
}

.active-menu {
	background-color: #2DAFCB !important;
	color: #fff !important;
}

.active-menu i {
	color: #fff !important;
}

.arrow {
	float: right;
	margin-top: 8px;
}

.fa.arrow:before {
	content: "\f104";
}

.active>a>.fa.arrow:before {
	content: "\f107";
}

.nav-second-level li, .nav-third-level li {
	border-bottom: none !important;
}

.nav-second-level li a {
	padding-left: 37px;
}

.nav-third-level li a {
	padding-left: 55px;
}

.sidebar-collapse, .sidebar-collapse .nav {
	background: none;
}

.sidebar-collapse .nav {
	padding: 0;
}

.sidebar-collapse .nav>li>a {
	color: #B5B5B5;
	background: transparent;
	text-shadow: none;
}

.sidebar-collapse>.nav>li>a {
	padding: 12px 10px;
}

.sidebar-collapse>.nav>li {
	border-bottom: 1px solid rgba(107, 108, 109, 0.19);
}

ul.nav.nav-second-level.collapse.in {
	background: #17191B;
}

.sidebar-collapse .nav>li>a:hover, .sidebar-collapse .nav>li>a:focus {
	outline: 0;
}

.navbar-side {
	border: none;
	background-color: transparent;
}

.top-navbar {
	background: #fff;
	border-bottom: none;
}

.top-navbar .nav>li>a>i {
	margin-right: 2px;
}

.top-navbar .navbar-brand:hover {
	color: #2DAFCB;
	background-color: rgb(43, 46, 51);
}

.dropdown-user li {
	margin: 8px 0;
}

.navbar-default {
	border: 0px solid black;
}

.navbar-header {
	background: transparent;
}

.navbar-default .navbar-toggle:hover, .navbar-default .navbar-toggle:focus
	{
	background-color: #B40101;
}

.navbar-default .navbar-toggle {
	border-color: #fff;
}

.navbar-default .navbar-toggle .icon-bar {
	background-color: #FFF;
}

.nav>li>a>i {
	margin-right: 10px;
	color: #666;
}

.page-header {
	margin-bottom: 30px;
	margin-top: 0px;
	border-bottom: 3px solid #2DAFCB;
}

</style>