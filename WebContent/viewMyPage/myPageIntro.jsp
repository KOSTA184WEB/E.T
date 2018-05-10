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

	<header>
		<%@ include file="../header.jsp" %>
	</header>

	
	<div class="container-fluid">
   <iframe src="${pageContext.request.contextPath}/ET?command=myPageMain" width="100%" height="850px" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
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