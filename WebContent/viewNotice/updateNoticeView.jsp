<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script> 
<SCRIPT >
function checkValid() {
	var f = window.document.updateFormNotice;
	if ( f.noticeTitle.value == "" ) {
		alert( "제목을 입력해 주세요." );
		f.noticeTitle.focus();
		return false;
	}
	if ( f.noticeContents.value == "" ) {
        alert( "내용을 입력해 주세요." );
        f.noticeContents.focus();
        return false;
    }
    
}

</SCRIPT>
</head>
<body>

<form name=updateFormNotice method=post action="${path}/ET" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="updateNotice" >
    <input type='hidden' name=noticeId value="${noticeDTO.noticeId}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#4D8923">
            <p align="center"><font color="white" size="3"><b>  공지 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20"> 
            <p align="right"><b><font color="black"><span style="font-size:9pt;">제 목</span></b></p>
        </td>
        <td width="450" height="20" ><b><font color="black"><span style="font-size:9pt;">
		<input type=text name="noticeTitle" size="30"
		 value="${noticeDTO.noticeTitle}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><font color="black"><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><font color="black"><span style="font-size:9pt;">
		<textarea name="noticeContents" cols="50" rows="10">${noticeDTO.noticeContents}</textarea></span></b></td>
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
        <td width="450" height="20" colspan="2" align="center"><b><font color="black"><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>

</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listNotice">후기리스트</a>&gt;</span></div>

</body>
</html>