<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../css/isotope.css" media="screen" />
<link rel="stylesheet" href="../js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="../css/prettyPhoto.css" rel="stylesheet" />
<link href="../css/style.css" rel="stylesheet" />
</head>
<%
	request.setCharacterEncoding("utf-8");
	String isCreate = (String)request.getAttribute("create");
	System.out.println(isCreate);
	if(isCreate != null){
%>
	<script type="text/javascript">top.location.href="viewMeeting/meetingIntro.html";</script>
	<%
	}
	%>
<header>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navigation">
			<div class="container">
				<div class="navbar-header">
					<div class="navbar-brand">
						<a href="../index.html"><h1>
								<span>M</span>ulti
							</h1></a>
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
							<li role="presentation"><a href="AboutUs.jsp">About US</a></li>
							<li role="presentation"><a href="meetingIntro.html" class="active">Meet</a></li>
							<li role="presentation"><a href="board.jsp">Rate</a></li>
							<li role="presentation"><a href="portfolio.html">MyPage</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
</header>
<!-- 컨테이너로 씌울 경우 : 고정값으로 정해져 버린다. 연구필요...... -->
<span><iframe src="createMeetingTop.html" width="100%"></iframe></span>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<iframe src="meetingForm.jsp" width="100%" height="500px" scrolling="no"></iframe>
</div>
<div class="sub-footer">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				&copy; 2015 <a target="_blank" href="http://bootstraptaste.com/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">bootstraptaste</a>. All
				Rights Reserved.
			</div>
			<!-- 
                        All links in the footer should remain intact. 
                        Licenseing information is available at: http://bootstraptaste.com/license/
                        You can buy this theme without footer links online at: http:f//bootstraptaste.com/buy/?theme=Multi
                    -->
			<div class="col-md-6">
				<ul class="pull-right">
					<li><a href="#">이용약관 |</a></li>
					<li><a href="#">사업자 정보 |</a></li>
					<li><a href="#">사업자 번호 |</a></li>
					<li><a href="#">신고 |</a></li>
					<li><a href="#">민원 |</a></li>
				</ul>
			</div>
		</div>
		<div class="pull-right">
			<a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
		</div>
	</div>
</div>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
<script src="../js/wow.min.js"></script>
<script src="../js/fancybox/jquery.fancybox.pack.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script src="../js/jquery.bxslider.min.js"></script>
<script src="../js/jquery.prettyPhoto.js"></script>
<script src="../js/jquery.isotope.min.js"></script>
<script src="../js/functions.js"></script>
<script>
		wow = new WOW({

		}).init();
	</script>
</html>