<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" heigth="500" bordercolordark="white" bordercolorlight="black">
<caption>Notice LIST</caption>
	<colgroup>
		<col width="5%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="10%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#4D8923">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">공지번호</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성일</span></b></font></p>
        </td>
        
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">첨부파일</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">파일용량</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.noticeList}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><font color="black"><span style="font-size:9pt;">등록된 공지가 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.noticeList}" var="noticeDTO">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${noticeDTO.noticeId}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="ET?command=detailNotice&noticeId=${noticeDTO.noticeId}">
					  ${noticeDTO.noticeTitle}
					</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${noticeDTO.noticeWriteday}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${noticeDTO.fileName}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${noticeDTO.fileSize}"/> byte</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${noticeDTO.noticeReadnum}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>

<div align=right>
<c:if test="${sessionScope.loginId=='etadmin'}">
<span style="font-size:9pt;">&lt;<a href="${path}/viewNotice/createNoticeView.jsp">글쓰기</a>&gt;</span>
</c:if>
<span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listNotice">리스트로 돌아가기</a>&gt;</span>
</div>

</body>
</html>