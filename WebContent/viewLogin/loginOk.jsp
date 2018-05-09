<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//***************  캐시에 있는 것 사용하지마(매번 새롭게 읽어들어라 - 새로고침)
	response.setHeader("Cache-Control","no-store");
%>    
<!-- 주석 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=application.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#logout").click(function(){
			if(confirm("정말 로그아웃 하시겠습니까?")){
				alert("<%=application.getContextPath()%>");
				location.href="../ET?command=logout";
			}else{
				alert("로그아웃 취소하셨습니다.");
			}			
		})
		
		$("#goMain").click(function(){
			location.href="../ET?command=myPageMain";
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
			location.href="viewMyPage/loginForm.jsp";
		</script>
		<%
	}else{
		%>
		<h1><%=session.getAttribute("loginId")%>님 로그인중....
		[ 접속시간 : <%=session.getAttribute("loginTime")%> ]</h1>
		<a href="${pageContext.request.contextPath}/viewIntro/intro.html">메인</a>
		<input type="button" value="메인페이지가기" id="goMain"/>	
		<input type="button" value="로그아웃" id="logout"/>		
		<%
	}
%>
</body>
</html>