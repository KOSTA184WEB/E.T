<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 주석 -->
	<form method="post" action="${pageContext.request.contextPath}/ET?command=login">
		ID :
		<input type="text" name="memberId" />
		<br />
		PWD :
		<input type="password" name="memberPw" />
		</br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>