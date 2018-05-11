<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
function sendUpdate(){//수정하기
	document.requestForm.command.value ="updateFormNotice";
	document.requestForm.submit();
}

function sendDelete(){//삭제하기
	if(confirm("정말 삭제하시겠습니까?")==true){
		document.requestForm.command.value ="deleteNotice";
		document.requestForm.submit();
	}
	
}

</script>
</head>
<body>
<body>
<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>

    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#4D8923">
            <p align="center"><font color="white" size="3"><b>
             게시물 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><font color="black"><span style="font-size:9pt;">작성일</span></b></p>
        </td>
        <td width="300" height="20">
        	<font color="black"><span style="font-size:9pt;"><b>${requestScope.noticeDTO.noticeWriteday}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><font color="black"><span style="font-size:9pt;">조회수</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><font color="black"><span style="font-size:9pt;"></span>${requestScope.noticeDTO.noticeReadnum}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20">
        	<font color="black"><span style="font-size:9pt;"><b>${requestScope.noticeDTO.noticeTitle}</b></span>
        </td>
        <td width="100" height="20" >
            <p align="right"><b><font color="black"><span style="font-size:9pt;">작성자</span></b></p>
        </td>
        <td width="100" height="20">
        	<font color="black"><span style="font-size:9pt;"><b>관리자</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">내용</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <font color="black"><span style="font-size:9pt;"><b><pre>${requestScope.noticeDTO.noticeContents}</pre></b></span></td>
    </tr>
    
      <c:if test="${noticeDTO.fileName!=null}"> <!-- 파일이 첨부가 되었다면 -->
       <tr>
        <td width="100" height="20">
            <p align="right"><b><font color="black"><span style="font-size:9pt;">다운로드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='downLoad?fileName=${noticeDTO.fileName}'>
    			${noticeDTO.fileName} 
      		</a>
      		  ( <fmt:formatNumber value="${noticeDTO.fileSize}"/> byte) <!-- 숫자 3자리씩 ,찍어주는거 -->
        </b></span>
        </td> 
    </tr>
    </c:if>
    
    <form name="requestForm" method=post action="${path}/ET">	
	
   <!--#${sessionScope.loginId}/${reviewDto.memberId}#<br>-->
    <c:if test="${sessionScope.loginId=='etadmin'}">
    <tr>
        <td height="20" colspan="4" align="center" valign="middle"><span style="font-size:9pt;">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="noticeId" value="${noticeDTO.noticeId}">
				<input type=hidden name="command" value="">
				<input type=button style="color:black" value="수정하기" onClick="sendUpdate()">
				<input type=button style="color:black" value="삭제하기" onClick="sendDelete()">
    </form>
		
		</td>
    </tr>
    </c:if>
</table>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listNotice">리스트로 돌아가기</a>&gt;</span></div>

</body>
</html>