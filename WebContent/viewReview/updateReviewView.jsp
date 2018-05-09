<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<SCRIPT >
function checkValid() {
	var f = window.document.updateFormReview;
	if ( f.reviewTitle.value == "" ) {
		alert( "제목을 입력해 주세요." );
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
	
    
}

</SCRIPT>
</head>
<body>
<form name=updateFormReview method=post action="ET" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="updateReview" >
    <input type='hidden' name=reviewId value="${reviewDto.reviewId}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  게시물 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
    	<td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">참여한모임</span></b></p>
        </td>
        <td>
        	<select name="meetListId">
			<c:forEach items="${meetList[1]}" var="name" varStatus="state">
				<option value="${meetList[0].get(state.index)}">${name}</option>
			</c:forEach>
			</select>
        </td>
    </tr>
    <tr>
        <td width="150" height="20"> 
            <p align="right"><b><span style="font-size:9pt;">제 목</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="reviewTitle" size="30"
		 value="${reviewDto.reviewTitle}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="reviewContents" cols="50" rows="10">${reviewDto.reviewContents}</textarea></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="reviewPw" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listReview">리스트로 돌아가기</a>&gt;</span></div>
</body>
</html>