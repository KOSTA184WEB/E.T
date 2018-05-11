<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
    
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script> -->

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#cancel").click(function(){		
		console.log("취소 선택");
		console.log($("#participantId").val());
		location.href="${path}/ET?command=leaveMeeting&participantId="+$("#participantId").val();	
	})	
})
</script>    
    
</head>
<body>
<%
	if(session.getAttribute("loginId")==null){ // 로그인 안했을 때
		%>
		<script>
			//alert("로그인 해주세요.");
			location.href="${path}/viewLogin/loginForm.jsp";
		</script>
		<%
	}else{
		%>

<div class="container">
<table class="table table-hover">
    <thead>
    <tr>
        <th>날짜</th>
        <th>시간</th>
        <th>제목</th>
        <th>신청일</th>
        <th>취소</th>
    </tr>
    </thead>
    
    <tbody>
    <c:choose>
	    
	    <c:when test="${empty requestScope.userMeetingList}"> 
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:9pt;">참여 내역이 없습니다. 같이 밥먹어요!</span></b></p>
	        </td>
	    </tr>	   
	    </c:when>
	    
	    <c:otherwise>
	    	<c:forEach items="${requestScope.userMeetingList}" var="meetingList">
	    		
	    		<tr>
        			<td id="meetingDate">${meetingList.meetingDate}</td>
        			<td id="meetingTime">${meetingList.meetingTime}</td>
        			<td><a href="ET?command=detailPartView&meetingId=${meetingList.meetingId}" style="color: black;">${meetingList.meetingTitle}</a></td>
        			<td id="participateDate">${meetingList.participantDate}</td>              
        			<td><input type="button" value="취소" id="cancel" ><input type=hidden id="participantId" value="${meetingList.participantId}"></td>       			   				
    			</tr>
    			
	    	</c:forEach>	    
	    </c:otherwise>  
    </c:choose>
    </tbody>
    
</table>
<hr/>

</div>

<%
	}
%>

</body>
</html>

