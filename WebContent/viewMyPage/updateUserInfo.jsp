<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 .a{border:solid red 5px}
 input{border:solid gray 1px}
 table{width:100%}
 th,td{border:1px gray solid; text-align:center;padding:3px}
 h2{text-align:center}
 
 /*a{text-decoration: none}*/
</style>

 <script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
$(function(){
	var p1 = $("#phone1").val().substr(0,3);
	$("#phone1").val(p1);
	var p2 = $("#phone2").val().substr(3,4);
	$("#phone2").val(p2);
	var p3 = $("#phone3").val().substr(6,4);
	$("#phone3").val(p3); 
}) 
	
</script>
</head>

<body>
<h2>내 정보 수정 </h2>

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


<form name="inForm" method="post" id="inForm" action="${path}/ET?command=updateUserInfo">
<table cellspacing="0">

	<tr>
	    <th>아이디</th>
	    <td style="text-align:left"><%=session.getAttribute("loginId")%></td>
	</tr>
	<tr>
	    <th>이름</th>
		<td style="text-align:left">${memberName}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td style="text-align:left">${memberBirth}</td>
	</tr>
	<tr>
	    <th>성별</th>
		<td style="text-align:left">
		<c:choose>
			<c:when test="${memberGender}='m'">
				<input type="radio" name="gender" readonly="readonly" checked>남성
			</c:when>
			<c:otherwise>
				<input type="radio" name="gender" readonly="readonly" checked>여성
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td style="text-align:left">
		<input type="text" size="3" name="phone1" id="phone1" value="${memberPhone}"> -
		<input type="text" size="6" name="phone2" id="phone2" value="${memberPhone}"> -
		<input type="text" size="6" name="phone3" id="phone3" value="${memberPhone}">
		</td>
	</tr>
	<tr>
		<th>이메일 주소</th>
		<td style="text-align:left">
		<input type="text" size="15" name="email" id="email" value="${memberEmail}">
		</td>
	</tr>
	<tr>
		<th>아이디 찾기 질문</th>
		<td style="text-align:left"> ${memberQuestion} <br>
		<input type="text" size="30" name="answer" id="answer" value="${memberAnswer}"></td>
	</tr>
	
	
	<tr>
		<td colspan="5" align="center"> 
			<input type="submit" value="수정하기"  id="update"/>
		</td>
	</tr>
</table>
</form>
<%
	}
%>

</body>
</html>