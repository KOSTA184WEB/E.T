<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
</head>
<header>
	<%@ include file="../header.jsp" %>
</header>
<!-- 컨테이너로 씌울 경우 : 고정값으로 정해져 버린다. 연구필요...... -->
<div style="width: 100%;height:250px"><iframe src="${pageContext.request.contextPath}/viewMeeting/createMeetingTop.html" width="100%" height="250"></iframe></div>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<iframe src="${pageContext.request.contextPath}/viewMeeting/meetingForm.jsp?meetingId=<%=request.getParameter("meetingId")%>" width="100%" height="500px" scrolling="no"></iframe>
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
</html>