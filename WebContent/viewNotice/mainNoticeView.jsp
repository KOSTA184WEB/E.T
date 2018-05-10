<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<link rel="stylesheet" href="${path}/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>

</head>
<body>
<header>
	<%@ include file="../header.jsp" %>
</header>

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" heigth="500" bordercolordark="white" bordercolorlight="black">
<caption>공지 LIST</caption>
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
		            ${noticeDTO.fName}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${noticeDTO.fSize}"/> byte</span></p>
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
<c:if test="${sessionScope.loginId=='admin'}">
<span style="font-size:9pt;">&lt;<a href="${path}/ET?command=insertReview&memberId=<%=session.getAttribute("loginId")%>">글쓰기</a>&gt;</span>
</c:if>
<span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listNotice">리스트로 돌아가기</a>&gt;</span></div>
<footer>
			<%@ include file="../footer.jsp" %>
		</footer>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.pack.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/functions.js"></script>
		<script>
		wow = new WOW({

		}).init();
		</script>
</body>
</html>