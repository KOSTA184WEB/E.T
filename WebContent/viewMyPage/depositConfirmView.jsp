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

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

$(function(){	
	
	// 현재 디파짓 보여주기
	var index = $('tr td:first').text();
 	if(index==1){
		$("#currentDeposit").val($("#currentDepositinList").text());
	} 
 	
	// 충전하기
	$("#addDeposit").click(function(){
		var charge = prompt("충전할 숟가락 갯수를 입력해 주세요.","");
				
		if(charge != null){
			charge = Number(charge);
			location.href="${path}/ET?command=chargeDeposit&chargeD="+charge;
		}else{
			alert("취소하셨습니다.");
		}			
	})	
})
</script>    
    
</head>
<body>

<div class="container">

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
<h3 style="text-align:center;">
${loginId} 님의 잔여 숟가락은  <input type="text" id="currentDeposit" value="0" size="5" readonly="readonly"/>개  입니다.    <input type="button" value="충전" id="addDeposit" style="background-color: #D0F5A9"/>
</h3>
<br>

<table class="table table-hover">
    <thead>
    <tr>
    	<th>번호</th>
        <th>날짜</th>
        <th>내용</th>
        <th>개수</th>
    </tr>
    </thead>
    
    <tbody>
    <c:choose>
	    
	    <c:when test="${empty requestScope.depositList}"> 
		<tr>
			<td colspan="5">
	            <p align="center"><b><span style="font-size:9pt;">숟가락 충전하시고 함께 밥먹어요! </span></b></p>
	        </td>
	    </tr>	   
	    </c:when>
	    
	    <c:otherwise>
	    	
	    	<c:forEach items="${requestScope.depositList}" var="depositList" varStatus="status"> 
	    		<tr>
	    			<td id="ind">${status.index+1}</td>
        			<td id="date">${depositList.depositUpdateDate}</td>
        			<td>${depositList.depositDescription}</td>
        			<td id="currentDepositinList">${depositList.currentDeposit}</td>       			 			   				
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>

