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
<header>
	<%@ include file="../header.jsp" %>
</header>
<!-- 컨테이너로 씌울 경우 : 고정값으로 정해져 버린다. 연구필요...... -->
<span><iframe src="createMeetingTop.html" width="100%"></iframe></span>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<iframe src="meetingForm.jsp" width="100%" height="500px" scrolling="no"></iframe>
</div>

<footer>
	<%@ include file="../footer.jsp" %>
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