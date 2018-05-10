<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 폼</title>
<style>
.a {
	border: solid red 5px
}

input {
	border: solid gray 1px
}

table {
	width: 100%
}

th, td {
	border: 1px gray solid;
	text-align: center;
	padding: 3px;
	color: black;
}

h2 {
	text-align: center
}

/*a{text-decoration: none}*/
</style>
</head>
<body>
	<h2>회원 가입 정보 입력</h2>
	<form name="inForm" method="post" id="inForm" action="${pageContext.request.contextPath}/ET?command=insertMember">
		<table cellspacing="0">
			<tr>
				<th>아이디</th>
				<td style="text-align: left"><input type="text" size="20" name="id" id="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td style="text-align: left"><input type="text" size="20" name="pw" id="pw"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td style="text-align: left"><input type="text" size="20" name="pwch" id="pwch"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td style="text-align: left"><input type="text" size="20" name="name" id="name"></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td style="text-align: left"><input type="text" size="20" name="nickname" id="nickname"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td style="text-align: left"><input type="text" name="birth" maxlength="8" placeholder="ex)20170508" size="10"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td style="text-align: left"><input type="radio" name="gender" value="M">남성 <input type="radio" name="gender" value="F">여성</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td style="text-align: left"><input type="text" size="11" name="phone" id="phone" placeholder="ex)010-0000-0000"></td>
			</tr>
			<tr>
				<th>이메일 주소</th>
				<td style="text-align: left"><input type="text" size="30" name="email" id="email" placeholder="ex)et@etetyaya.com"></td>
			</tr>
			<tr>
				<th>아이디 찾기 질문</th>
				<td style="text-align: left"><input type="text" size="30" name="ask" id="ask" value="당신의 이름은?">
					<br> <input type="text" size="30" name="answ" id="answ"></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit" value="가입하기" id="btn" /></td>
			</tr>
		</table>
	</form>
	<br>
</body>
</html>