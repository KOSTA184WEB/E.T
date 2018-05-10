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
<script>
$(function(){
	//검색하기
	$("input[value=검색]").click(function(){
		var keyWord = $("input[name=keyWord]").val() //입력한값
		if(keyWord==""){
			alert("검색단어를 입력해주세요");
			$("input[name=keyWord]").focus();
			return;
		}
		
		//전송하기
		$("form[name=search]").submit();//액션에서 설정된 곳 이동
	});	
})

function sendDelete(){//삭제하기
	if(confirm("정말 삭제하시겠습니까?")==true){
		var inputEle = document.forms.AdminDeleteForm.command;
		//document.AdminDeleteForm.command.value="adminDeleteReview";
		inputEle.value="adminDeleteReview";
		alert(inputEle.value);
		document.forms.AdminDeleteForm.submit();
	}
	
}
</script>
</head>
<body>

<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" heigth="500" bordercolordark="white" bordercolorlight="black">
<caption>Review LIST</caption>
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
            <font color="white"><b><span style="font-size:9pt;">리뷰번호</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">리뷰제목</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성자</span></b></font></p>
        </td>
        <td bgcolor="#4D8923">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">음식점</span></b></font></p>
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
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><font color="black"><span style="font-size:9pt;">등록된 후기가 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="reviewDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.reviewId}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="ET?command=detailReview&reviewId=${reviewDto.reviewId}&meetingId=${reviewDto.meetingId}">
					  ${reviewDto.reviewTitle}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.memberId}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.resId}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.reviewWriteday}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.fileName}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${reviewDto.fileSize}"/> byte</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><font color="black"><span style="font-size:9pt;">
		            ${reviewDto.reviewReadnum}</span></p>
		        </td>
		        <form name="AdminDeleteForm" method=post action="${path}/ET">
		        <c:if test="${sessionScope.loginId=='etadmin'}">
		        <td>
		        	<input type=hidden name="reviewId" value="${reviewDto.reviewId}">
		        	<input type=hidden name="command" value="">
		        	<input type=button style="color:black" value="삭제" onClick="sendDelete()">
		        </td>
		        </form>
		        </c:if>
		        
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<form name="search" action="ET?command=selectReview" method="post">
 <select name="keyField" style="color:black">
   <option value="0">--선택--</option>
   <option value="memberId">작성자</option>
   <option value="reviewTitle">제목</option>
   <option value="resId">음식점</option>
 </select>
 
<input type="text" style="color:black" placeholder="Search Here" name="keyWord"/>
<input type="button" style="color:black" value="검색" />  
</form>

<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/ET?command=insertReview&memberId=<%=session.getAttribute("loginId")%>">글쓰기</a>&gt;</span>
<span style="font-size:9pt;">&lt;<a href="${path}/ET?command=listReview">리스트로 돌아가기</a>&gt;</span></div>

</body>
</html>