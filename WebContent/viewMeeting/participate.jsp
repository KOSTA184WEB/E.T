<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css"
	type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />


</head>
<body>

<header>
		<nav class="navbar navbar-default navbar-static-top">
			<div class="navigation">
				<div class="container">
					<div class="navbar-header">
						<div class="navbar-brand">
							<a href="index.html"><h1>
									<span>E.T</span>
								</h1></a>
						</div>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								SignUp</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								LogIn</a></li>
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
								<li><a href="${pageContext.request.contextPath}/viewAboutUs/AboutUs.jsp" class="active">About US</a></li>
								<li><a href="${pageContext.request.contextPath}/viewMeeting/Meet.jsp">Meet</a></li>
								<li><a href="board.jsp">Rate</a></li>
								<li><a href="portfolio.html">MyPage</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">아이콘 들어가는 부분</div>


	<div class="container-fluid">
		<div class="row">

			<div class="col-md-8">

				<h1>참여하기</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>모임날짜</th>
					<th>인원</th>
					<th>지역</th>
				</tr>
  
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 만남이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="meeting">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.memberId }</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="ET?command=detailPartView&meetingId=${meeting.meetingId}">
					  ${meeting.meetingTitle}
					</a>
					</span></p>
		        </td>
		       
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.memberId }</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.meetingDate}</span></p>
		        </td>

		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.maxNum }</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.maxNum }</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>

		</table>

			</div>
			 
			 
			 <div class="col-md-4">
					 <div class="widget search">
                        <form class="form-inline">
                            <input type="text" class="form-control search_box" autocomplete="off" placeholder="Search Here">
                            <input type="button" class="btn btn-primary readmore" value="검색">
                        </form>
                    </div><!--/.search-->
			 </div>
			 
			 
		   </div>
		  
		  
		  


	</div>





	<footer>
		<div class="footer">
			<div class="container">
				<div class="col-md-4 wow fadeInUp" data-wow-offset="0"
					data-wow-delay="0.2s">
					<h2>Multi</h2>
					<p>In a elit in lorem congue varius. Sed nec arcu. Etiam sit
						amet augue. Fusce fermen tum neque a rutrum varius odio pede
						ullamcorp-er tellus ut dignissim nisi risus non tortor. Aliquam
						mollis neque.</p>

					<ul class="social-network">
						<li><a href="#" data-placement="top" title="Facebook"><i
								class="fa fa-facebook fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Twitter"><i
								class="fa fa-twitter fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Linkedin"><i
								class="fa fa-linkedin fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Pinterest"><i
								class="fa fa-pinterest fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Google plus"><i
								class="fa fa-google-plus fa-1x"></i></a></li>
					</ul>
				</div>

				<div class="col-md-4 wow fadeInUp" data-wow-offset="0"
					data-wow-delay="0.4s">
					<h3>RECENT POSTS</h3>
					<ul>
						<li>Awesome Design with Overviews</li>
						<hr>
						<li>Great Design with Features</li>
						<hr>
						<li>Limitless functions & Works</li>
						<hr>
						<li>Multi is simple and clean design</li>
					</ul>
				</div>

				<div class="col-md-4 wow fadeInUp" data-wow-offset="0"
					data-wow-delay="0.6s">
					<h3>CEO CONTACT</h3>
					<ul>
						<li><i class="fa fa-home fa-2x"></i> 대전광역시 서구 둔산2동 둔산북로 41</li>
						<hr>
						<li><i class="fa fa-phone fa-2x"></i> +82 010-2139-7753</li>
						<hr>
						<li><i class="fa fa-envelope fa-2x"></i> oneStar@gmail.com</li>
					</ul>
				</div>

			</div>
		</div>

		<div class="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						&copy; 2015 <a target="_blank" href="http://bootstraptaste.com/"
							title="Free Twitter Bootstrap WordPress Themes and HTML templates">bootstraptaste</a>.
						All Rights Reserved.
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
					<a href="#home" class="scrollup"><i
						class="fa fa-angle-up fa-3x"></i></a>
				</div>
			</div>
		</div>
	</footer>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/functions.js"></script>
	<script>
		wow = new WOW({

		}).init();
	</script>
	
	

</body>
</html>