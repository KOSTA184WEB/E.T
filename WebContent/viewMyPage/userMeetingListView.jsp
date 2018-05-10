<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('a[data-toggle="tab"]').on('hidden.bs.tab', function(e){
	alert("이벤트 실행됨");
    });
});

</script>

<title></title>
</head>
<body>

<div class="container">
	
	<ul id="myTab" class="nav nav-tabs" role="tablist">
	  <li role="presentation" class="active"><a data-target="#upcomingMeeting" id="home-tab" role="tab" data-toggle="tab" 
	  	aria-controls="home" aria-expanded="true" style="color: green">신청 모임</a></li>
	  <li role="presentation" class=""><a data-target="#pastMeeting" role="tab" id="profile-tab" data-toggle="tab" 
	  	aria-controls="profile" aria-expanded="false" style="color: green">지난 모임</a></li>
	</ul>
	
	<div id="myTabContent" class="tab-content">
	  <div role="tabpanel" class="tab-pane fade active in" id="upcomingMeeting" aria-labelledby="upcomingMeeting-tab">
	    <!-- 첫번째 탭 내용 -->	    

	    <%@ include file="userMeetingList.jsp"%>	    
	  </div>
	  
	  <div role="tabpanel" class="tab-pane fade" id="pastMeeting" aria-labelledby="pastMeeting-tab">
	     <!-- 두번째 탭 내용 -->

		<%@ include file="pastMeetingList.jsp"%>
	  </div>
	  
</div>
</div>

</body>
</html>