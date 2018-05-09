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
	<%@ include file="../header.jsp" %>
</header>
	
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
							<a href="#"><i class="fa fa-female fa-5x"></i></a>	
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.3s">
							<h4>모집하기</h4>
							<p>당신과 멋진 식사를 함께할 친구를 찾습니다.</p>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.9s">
							<a href="../ET?command=selectParticipating"><i class="fa fa-android fa-5x"></i></a>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.9s">
							<h4>참여하기</h4>
							<p>많은 모임들이 개설되어 있습니다. 참여할 모임을 찾아보세요.</p>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="1.5s">
							<a href="meetView/hotPlaceListView.jsp"><i class="fa fa-eye fa-5x"></i></a>
						</div>
						<div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="1.5s">
							<h4>핫플레이스</h4>
							<p>가장 많은 사람들이 다녀간 모임 장소입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
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