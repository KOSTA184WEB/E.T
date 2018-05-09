<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
function oneOver(){
	document.getElementById("td1").className = 'fa fa-user fa-spin fa-5x';
}

function oneOut(){
	document.getElementById("td1").className = 'fa fa-user fa-5x';
}

function twoOver(){
	document.getElementById("td2").className = 'fa fa-sign-in fa-spin fa-5x';
}

function twoOut(){
	document.getElementById("td2").className = 'fa fa-sign-in fa-5x';
}

function threeOver(){
	document.getElementById("td3").className = 'fa fa-magic fa-spin fa-5x';
}

function threeOut(){
	document.getElementById("td3").className = 'fa fa-magic fa-5x';
}

function click_img(){
	alert('로그인 후 이용해주세요.');
	location.href = '../viewLogin/loginForm.jsp';
}

</script>

</head>
<body>
	<header>
		<%@ include file="../header.jsp" %>
	</header>
	
	
	<%
		if(session.getAttribute("loginId")==null){
			
		
	%>
	<div class="services">
		<div class="container">
			<div class="text-center">
				<div class="services-box">
					<div class="wow bounceInDown" data-wow-offset="0" data-wow-delay="0.3s">
						<h2>ET 서비스</h2>
					</div>
					<div class="wow bounceInDown" data-wow-offset="0" data-wow-delay="0.6s">
						<p>이제 혼자 먹지 마세요!!!!</p>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.3s">
							<i onclick="click_img()" id="td1" class="fa fa-user fa-5x" style="background:#51E87A" onmouseover="oneOver()" onmouseout="oneOut()"></i>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.3s">
							<h4>모집하기</h4>
							<p>당신과 멋진 식사를 함께할 친구를 찾습니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.9s">
							<i onclick="click_img()" id="td2" class="fa fa-sign-in fa-5x" style="background:#FF773A" onmouseover="twoOver()" onmouseout="twoOut()"></i>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.9s">
							<h4>참여하기</h4>
							<p>많은 모임들이 개설되어 있습니다. 참여할 모임을 찾아보세요.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="1.5s">
							<i onclick="click_img()" id="td3" class="fa fa-magic fa-5x" style="background:#79ACFF" onmouseover="threeOver()" onmouseout="threeOut()"></i>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="1.5s">
							<h4>핫플레이스</h4>
							<p>가장 많은 사람들이 다녀간 모임 장소입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<%
		}else{
			
		%>
		
		<div class="services">
		<div class="container">
			<div class="text-center">
				<div class="services-box">
					<div class="wow bounceInDown" data-wow-offset="0" data-wow-delay="0.3s">
						<h2>ET 서비스</h2>
					</div>
					<div class="wow bounceInDown" data-wow-offset="0" data-wow-delay="0.6s">
						<p>이제 혼자 먹지 마세요!!!!</p>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.3s">
							<a href="createMeeting.jsp"><i id="td1" class="fa fa-user fa-5x" style="background:#51E87A" onmouseover="oneOver()" onmouseout="oneOut()"></i></a>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.3s">
							<h4>모집하기</h4>
							<p>당신과 멋진 식사를 함께할 친구를 찾습니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.9s">
							<a href="${pageContext.request.contextPath}/ET?command=selectParticipating"><i id="td2" class="fa fa-sign-in fa-5x" style="background:#FF773A" onmouseover="twoOver()" onmouseout="twoOut()"></i></a>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.9s">
							<h4>참여하기</h4>
							<p>많은 모임들이 개설되어 있습니다. 참여할 모임을 찾아보세요.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="1.5s">
							<a href="${pageContext.request.contextPath}/viewHotplace/hotPlaceListView.jsp"><i id="td3" class="fa fa-magic fa-5x" style="background:#79ACFF" onmouseover="threeOver()" onmouseout="threeOut()"></i></a>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="1.5s">
							<h4>핫플레이스</h4>
							<p>가장 많은 사람들이 다녀간 모임 장소입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<% } %>
		
		
		<footer>
			<%@ include file="../footer.jsp" %>
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