<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css"
	type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />


</head>
<body>

<header>
		<%@ include file="../header.jsp" %>
</header>

	<div class="container">아이콘 들어가는 부분</div>


	<div class="container-fluid">
		<div class="row">

			<div class="col-md-8">

				<h1>참여하기</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>모임날짜</th>
					<th>인원</th>
					<th>지역</th>
				</tr>
  
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 만남이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="meeting">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.memberId }</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="ET?command=detailPartView&meetingId=${meeting.meetingId}">
					  ${meeting.meetingTitle}
					</a>
					</span></p>
		        </td>
		       
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.memberId }</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.meetingDate}</span></p>
		        </td>

		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.maxNum }</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${meeting.maxNum }</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>

		</table>

			</div>
			 
			 
			 <div class="col-md-4">
					 <div class="widget search">
                        <form class="form-inline">
                            <input type="text" class="form-control search_box" autocomplete="off" placeholder="Search Here">
                            <input type="button" class="btn btn-primary readmore" value="검색">
                        </form>
                    </div><!--/.search-->
			 </div>
			 
			 
		   </div>
		  
		  
		  


	</div>





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