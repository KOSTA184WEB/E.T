<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<HEAD>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<SCRIPT language=javascript>
function map_value(){
	document.map.location='<%=request.getContextPath()%>/viewMeeting/meetingPartMap.jsp?lat=${dto.lat}&lng=${dto.lng}&name=${dto.resName}';
}
function sendUpdate(){
	location.href="<%=request.getContextPath()%>/viewMeeting/createMeeting.jsp?meetingId="+ document.requestForm.meetingId.value;
	}

	function sendMeet() {
		if (confirm("이 모임에 참여하시겠습니까?") == true) {
			document.requestForm.command.value = "meet";
			document.requestForm.submit();
		} else {
			return;
		}
	}

	function deleteMeet() {
		alert("관리자에게 문의해주세요");
	}
</script>
</HEAD>
<body onLoad='map_value()'>
	<form name="requestForm" method=post action="${pageContext.request.contextPath}/ET">
		<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
			<tr>
				<td width="1220" height="20" colspan="4" bgcolor="#00cc00">
					<p align="center"><font color="white" size="3"><b>게시물 자세히보기</b></font></p>
				</td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="right"><b><span style="font-size: 9pt; color: black;"><b>음식점 주소</b></span></b></p>
				</td>
				<td width="450" height="20" colspan="3"><span style="font-size: 9pt; color: black;">${dto.resAddr}</span></td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="right"><b><span style="font-size: 9pt; color: black;">음식점 이름</span></b></p>
				</td>
				<td width="300" height="20"><span style="font-size: 9pt; color: black;">${dto.resName}</span></td>
				<td width="100" height="20">
					<p align="right"><b><span style="font-size: 9pt; color: black;">참여인원</span></b></p>
				</td>
				<td width="100" height="20">
					<p><span style="font-size: 9pt; color: black;">${dto.applyNum}</span></p>
				</td>
			</tr>
			<tr>
				<td width="100" height="20">
					<p align="right"><span style="font-size: 9pt; color: black;"><b>성별</b></span></p>
				</td>
				<td width="450" height="20" colspan="3"><span style="font-size: 9pt; color: black;">${dto.genderOption}</span></td>
			</tr>
			<tr>
				<td width="100" height="20" valign="top">
					<p align="right"><b><span style="font-size: 9pt; color: black;">만남날짜</span></b></p>
				</td>
				<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
				<td width="450" height="20" valign="top" colspan="3"><span style="font-size: 9pt; color: black;"><pre>${dto.meetingDate}</pre></span></td>
			</tr>
			<tr>
				<td width="100" height="200" valign="top">
					<p align="right"><b><span style="font-size: 9pt; color: black;">설명</span></b></p>
				</td>
				<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
				<td width="450" height="200" valign="top" colspan="3"><span style="font-size: 9pt; color: black;"><pre>${dto.meetingDescription}</pre></span></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan=4><iframe name="map"style="border-collapse: collapse;width:100%;height:300px;overflow:hidden;"></iframe></td>
			</tr>
			<c:choose>
				<%--    <c:when test="${requestScope.check == 1}">
    <tr>
        <td height="100" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="meetingId" value="${dto.meetingId}">
				<input type=hidden name="command" value="">
				<input type=button value="모임나오기" onClick="">
		
		</td>
	</tr>
		</c:when> --%>
				<c:when test="${sessionScope.loginId eq dto.memberId}">
					<tr>
						<td height="100" colspan="4" align="center" valign="middle">
							<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. --> <input type=hidden name="meetingId" value="${dto.meetingId}"> <input type=hidden name="command"
								value=""
							> <input type=button value="수정하기" onClick="sendUpdate()"> <input id="btn" type=button value="삭제하기" onClick="deleteMeet()">
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td height="100" colspan="4" align="center" valign="middle">
							<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. --> <input type=hidden name="meetingId" value="${dto.meetingId}"> <input type=hidden name="command"
								value=""
							> <input id="btn" type=button value="참여하기" onClick="sendMeet()">
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</body>
<div align=right>
	<span style="font-size: 9pt;">&lt;<a href="${pageContext.request.contextPath}/ET?command=selectParticipating">리스트로 돌아가기</a>&gt;
	</span>
</div>
