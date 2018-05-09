<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />

<script>
	function overColor_nav1(){
		var element = document.getElementById("nav1");
		element.style.color = "#4D8923";
		
	}
	
	function outColor_nav1(){
		var element = document.getElementById("nav1");
		element.style.color = "#000000";
		
	}
	
	function overColor_nav2(){
		var element = document.getElementById("nav2");
		element.style.color = "#4D8923";
		
	}
	
	function outColor_nav2(){
		var element = document.getElementById("nav2");
		element.style.color = "#000000";
		
	}
	
	function overColor_nav3(){
		var element = document.getElementById("nav3");
		element.style.color = "#4D8923";
	}
	
	function outColor_nav3(){
		var element = document.getElementById("nav3");
		element.style.color = "#000000";
	}
	
</script>

</head>
<body>


	<nav class="navbar navbar-default navbar-static-top">
		<div class="navigation">
			<div class="container">
				<div class="navbar-header">
					<div class="navbar-brand">
						<a href="#">
								<img src="../images/ET_Logo.png" width="125px" height="100px">
							</a>
					</div>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> LogIn</a></li>
				</ul>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs navbar-right">
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li role="presentation"><a href="../viewAboutUs/AboutUs.jsp"><font color="#4D8923">About US</font></a></li>
							<li role="presentation"><a id="nav1" href="../viewMeeting/meetingIntro.jsp" onmouseover="overColor_nav1()" onmouseout="outColor_nav1()">Meet</a></li>
							<li role="presentation"><a id="nav2" href="board.jsp" onmouseover="overColor_nav2()" onmouseout="outColor_nav2()">Rate</a></li>
							<li role="presentation"><a id="nav3" href="portfolio.html" onmouseover="overColor_nav3()" onmouseout="outColor_nav3()">MyPage</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	
	

</body>
</html>