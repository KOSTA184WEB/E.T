<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<link rel="stylesheet" href="${path}/css/style.css">

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.reviewTitle.value == "") {
	    alert( "제목 입력해 주세요." );
	    f.reviewTitle.focus();
		return false;
    }
	if ( f.reviewContents.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.reviewContents.focus();
		return false;
	}
	if ( f.reviewPw.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.reviewPw.focus();
        return false;
    }
	
    return true;
}

</SCRIPT>
</head>


<%
	if(!session.getAttribute("loginId").equals("etadmin") || session.getAttribute("loginId")==null){ // 관리자 아이디가 아니거나 로그인 안했을 때
		%>
		<script>
			//alert("로그인 해주세요.");
			location.href="index.html";
		</script>
		<%
	}else{
%>

<body>			
<form name="writeForm" method="post" action="${path}/ET?command=createNotice" 
  onSubmit='return checkValid()' enctype="multipart/form-data"> <!-- 받을때 multipartrquest로 받아야됨 -->
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#4D8923">
            <p align="center"><font color="white" size="3"><b> 공지 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><font color="black"><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><font color="black"><span style="font-size:9pt;">
		<input type=text name="noticeTitle" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20"><b><font color="black"><span style="font-size:9pt;">
		<textarea name="noticeContents" cols="50" rows="10"></textarea></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">공개여부</span></b></p>
        </td>
        <td>
        	<select name="isPublic" style="color:black">
        		<option value="O">공개</option>
        		<option value="X">비공개</option>
			</select>
        </td>
    </tr>
     <tr>
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">*파일첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><font color="black"><font color="black"><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>  
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><font color="black"><span style="font-size:9pt;"><input type=submit value=글쓰기> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>
		
<%
	}
%>
		
</body>
</html>