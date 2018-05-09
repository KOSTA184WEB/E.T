<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	var loginMsg = "${requestScope.loginMsg}";
	function loginCheck(){
		if(loginMsg == "success"){
			opener.location.href="${pageContext.request.contextPath}/viewIntro/intro.jsp";
			self.close();
		}else{
			alert("아이디와 비밀번호를 확인하여주세요");
			location.href="${pageContext.request.contextPath}/viewLogin/loginForm.jsp";
		}
	}
	loginCheck();
</script>
</head>
<body>

</body>
</html>