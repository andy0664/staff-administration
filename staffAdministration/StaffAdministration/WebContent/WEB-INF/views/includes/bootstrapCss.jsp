<!-- Bootstrap core CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.6.0/bootstrap-table.min.css">

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	overflow-x: hidden;
}

/* landing page */
.landing-page {
	background-image:
		url(http://ironsummitmedia.github.io/startbootstrap-landing-page/img/intro-bg.jpg);
	height: 100%;
	background-size: cover;
}

.landing-page>.row {
	padding-top: 200px;
}

.landing-page>.row>.col-md-4 {
	color: white;
}

.landing-page>.row>.col-md-4>.form-signin>.form-control {
	margin-bottom: 15px;
	background-color: white;
}

.intro-message>h1 {
	margin-top: 30px;
	text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.6);
	font-size: 5em;
}

/* .top { */
/*   width: 100%; */
/*   max-width: 1600px; */
/*   z-index: -10; */
/*   position: fixed; */
/*   height: 65px; */
/*   top: 0; */
/*   background-color: #ffffff; */
/*   padding-left: 15px; */
/*   font-family: Lato, sans-serif !important; */
/*   padding: 20px 30px 10px 28px; */
/* } */

/* .top div { */
/*   float: right; */
/*   padding-top: 14px; */
/*   letter-spacing: 4px; */
/* } */

/* wrapper */
#wrapper {
	width: 100%;
	background: #2b2e33;
}

#page-wrapper {
	margin: 0 0 0 260px;
	padding: 15px 0px;
	min-height: 1700px;
	position: relative;
	background: #F0F0F0;
}

#page-wrapper-subpages {
	margin: 0 0 0 260px;
	padding: 15px 0px;
	min-height: 919px;
	position: relative;
	background: #fff;
}

#page-inner-subpages {
	width: 100%;
	padding-right: 25px;
	padding-left: 25px;
	background-color: transparent;
}

/* Login */
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .checkbox {
	font-weight: normal;
}

.logout-form {
	display: block;
	padding: 3px 20px;
	clear: both;
	font-weight: 400;
	line-height: 1.42857143;
	color: #333;
	white-space: nowrap;
}

.logout-button {
	background-color: #fff;
	border-color: #fff;
	color: black;
	font-size: 14px;
}

/*----------------------------------------------
    MENU STYLES    
------------------------------------------------*/
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

/* Panel start */
.panel {
	padding: 15px;
	margin-bottom: 27px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 0px;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
}

.panel-heading {
	padding: 10px 15px;
	margin: -15px -15px 5px;
	background-color: #f5f5f5;
	border-bottom: 1px solid #ddd;
	border-top-right-radius: 3px;
	border-top-left-radius: 3px;
}

.panel-violet {
	border-color: #774177;
	color: #fff;
	background-color: #774177;
}

.panel-violet>.panel-heading {
	color: #fff;
	background-color: #774177;
	border-color: #774177;
	border: 0px;
}

.panel-news {
	color: black;
	border-color: #708090;
}

.panel-news>.panel-heading {
	color: #fff;
	background-color: #708090;
	border-color: #708090;
	border-radius: 0px;
}

.panel-news>.footer-news {
	color: #fff;
	background-color: #708090;
	border-color: #708090;
}

.panel-green {
	border-color: #5cb85c;
	color: #fff;
	background-color: #5cb85c;
}

.panel-green>.panel-heading {
	border-color: #5cb85c;
	color: #fff;
	background-color: #5cb85c;
}

.panel-blue {
	border-color: #337ab7;
	color: #fff;
	background-color: #337ab7;
}

.panel-blue>.panel-heading {
	border-color: #337ab7;
	color: #fff;
	background-color: #337ab7;
}

.panel-blue>.panel-body {
	border-color: #337ab7;
	color: #fff;
	background-color: #fff;
}

.panel-yellow {
	border-color: #f0ad4e;
	color: #fff;
	background-color: #f0ad4e;
}

.panel-yellow>.panel-heading {
	border-color: #f0ad4e;
	color: #fff;
	background-color: #f0ad4e;
}

.panel-red {
	border-color: #d9534f;
	color: #fff;
	background-color: #d9534f;
}

.panel-red>.panel-heading {
	border-color: #d9534f;
	color: #fff;
	background-color: #d9534f;
}

.panel-anncouncement {
	border-color: #774177;
	color: #fff;
	background-color: #fff;
	border-radius: 4px;
}

.panel-anncouncement>.panel-heading {
	border-color: #774177;
	color: #fff;
	background-color: #774177;
}

.panel-anncouncement>.panel-body {
	border-color: #774177;
	color: black;
	background-color: #fff;
}

.panel-charts {
	color: #000;
	border-color: #FFF;
	font-weight: bold;
	background: #FFFFFF;
	font-size: 16px;
	border-color: #ECECEC;
	margin-bottom: 27px;
}

/* Panel end */

/* Fonts start */
.huge {
	font-size: 40px;
}

/* Fonts end */
.navbar-hr {
	position: relative;
	border: 1px solid transparent;
	background-color: #333
}

.navbar-static-top {
	border-width: 0 0 1px;
}

#features {
	text-align: center;
}

<
style type ="text /css">body {
	padding-top: 10px;
	padding-bottom: 10px;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizelegibility;
}

#features img {
	margin: 0 0 20px;
}

ul.unstyled {
	list-style: none;
	padding: 0;
}

/* Footer */
.footer-landing-page {
	background: #fff;
	color: black;
	font-size: 11px;
	margin-top: 20px;
}

.navbar-fixed-bottom {
	background: #2b2e33;
	color: #eee;
	font-size: 11px;
}

.site-footer {
	position: relative;
	margin-top: 40px;
	padding-top: 40px;
	padding-bottom: 40px;
	font-size: 12px;
	line-height: 1.5;
	color: #777;
	border-top: 1px solid #eee;
}

/* Footer end */
.status-field {
	margin-top: 10px;
	padding-bottom: 5px;
	border-top: 2px solid #fff;
}

.status-buttons {
	margin-top: 15px;
}

.my-inner {
	padding: 10px;
	background-color: #eee;
	border: 1px solid #ddd;
	background-color: rgba(86, 61, 124, .15);
	border: 1px solid rgba(86, 61, 124, .2);
}

.request-conainer {
	border: 1px solid #ddd;
	border-radius: 4px;
	width: 560px;
}

/* New feed */
.glyphicon {
	margin-right: 4px !important; /*override*/
}

.pagination .glyphicon {
	margin-right: 0px !important; /*override*/
}

.pagination a {
	color: #555;
}

.panel ul {
	padding: 0px;
	margin: 0px;
	list-style: none;
}

.news-item {
	padding: 4px 4px;
	margin: 0px;
	border-bottom: 1px dotted #555;
}

.panel-footer {
	padding: 10px 15px;
	background-color: #f5f5f5;
	border-top: 1px solid #ddd;
	border-bottom-right-radius: 3px;
	border-bottom-left-radius: 3px;
}

/* News feed end*/
@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		/* 		padding-left: 5px; */
		/* 		padding-right: 5px; */
	}
}
</style>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
