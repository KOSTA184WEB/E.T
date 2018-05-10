<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

    <meta charset="UTF-8">
    <title>Title</title>
    <!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">

</script>    
    
</head>
<body>

<%
	if(session.getAttribute("loginId")==null){ // 로그인 안했을 때
		%>
		<script>
			//alert("로그인 해주세요.");
			location.href="../viewMyPage/loginForm.jsp";
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
    </tr>
    </thead>
    
    <tbody>
    <c:choose>
	    
	    <c:when test="${empty requestScope.pastMeetingList}"> 
		<tr>
	        <td colspan="4">
	            <p align="center"><b><span style="font-size:9pt;">신청 내역 없을때 뜸</span></b></p>
	        </td>
	    </tr>	   
	    </c:when>
	    
	    <c:otherwise>
	    	<c:forEach items="${requestScope.pastMeetingList}" var="pastList">
	    		
	    		<tr>
        			<td id="meetingDate">${pastList.meetingDate}</td>
        			<td id="meetingTime">${pastList.meetingTime}</td>
        			<td><a href="ET?command=detailPartView&meetingId=${pastList.meetingId}" style="color: black;">${pastList.meetingTitle}</a></td>
        			<td id="participateDate">${pastList.participantDate}</td>             
    			</tr>
	    	</c:forEach>	    
	    </c:otherwise>  
    </c:choose>
    </tbody>
    
</table>

</div>

		<%
	}
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>

