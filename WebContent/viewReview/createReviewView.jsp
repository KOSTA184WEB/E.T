<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<link rel="stylesheet" href="${path}/css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	if ( f.resRate.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.resRate.focus();
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
<body>
				
<form name="writeForm" method="post" action="ET?command=createReview" 
  onSubmit='return checkValid()' enctype="multipart/form-data"> <!-- 받을때 multipartrquest로 받아야됨 -->
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
<input type='hidden' name=memberId value="${requestScope.memberId}">
<input type='hidden' name=resId value="${requestScope.resId}">

    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#4D8923">
            <p align="center"><font color="white" size="3"><b> 후기 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><font color="black"><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><font color="black"><span style="font-size:9pt;">
		<input type=text name="reviewTitle" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20"><b><font color="black"><span style="font-size:9pt;">
		<textarea name="reviewContents" cols="50" rows="10"></textarea></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">참여한모임</span></b></p>
        </td>
        <td>
        	<select name="meetListId" style="color:black">
			<c:forEach items="${meetList[1]}" var="name" varStatus="state">
				<option value="${meetList[0].get(state.index)}">${name}</option>
			</c:forEach>
			</select>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
			<p align="right"><b><font color="black"><span style="font-size:9pt;">음식점 평점</span></b></p>
		</td>
        <td width="450" height="20"><b><font color="black"><span style="font-size:9pt;">
			<input type=text name="resRate" size="30"></span></b></td>
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
        <td width="150" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><font color="black"><span style="font-size:9pt;">
        		<input type=password name="reviewPw" size="12">(글 수정, 삭제시 필요합니다.)
        	   </span></b>
        </td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><font color="black"><span style="font-size:9pt;"><input type=submit value=글쓰기> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listReview">리스트로 돌아가기</a>&gt;</span></div>

</body>
</html>