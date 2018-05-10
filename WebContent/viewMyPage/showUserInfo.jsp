<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<style>

@import url(http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700);
@import url(http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700);



body {
    background: #fff;
   font-family: 'Roboto', sans-serif;
   color:#333;
   line-height: 22px;  
   width: 100%; 
   
   
   scrollbar-face-color:#FFFFFF;
scrollbar-highlight-color: navy;
scrollbar-3dlight-color: #FFFFFF;
scrollbar-shadow-color: navy;
scrollbar-darkshadow-color: #FFFFFF;
scrollbar-track-color: #FFFFFF;
scrollbar-arrow-color: navy
}

h1, h2, h3, h4, h5, h6 {
   font-family: 'Roboto Condensed', sans-serif;
   font-weight: 400;
   color:#111;
   margin-top:5px;
   margin-bottom:5px;
}
h1, h2, h3 {
   text-transform:uppercase;
}

input.upload {
    position: absolute;
    top: 0;
    right: 0;
    margin: 0;
    padding: 0;
    font-size: 12px;
    cursor: pointer;
    opacity: 1;
    filter: alpha(opacity=1);    
}

.form-inline .form-group{
    margin-left: 0;
    margin-right: 0;
}
.control-label {
    color:#333333;
}

</style>

 <script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">

  $(function(){
	$("#update").click(function(){ // 회원 정보 수정
		location.href="${path}/ET?command=showUpdateUserInfo";
	})
	
	$("#leave").click(function(){ // 회원 탈퇴
		location.href="${path}/ET?command=deleteUserInfo";
	})
	
  });
   
</script>

</head>
<body>

<%
	if(session.getAttribute("loginId")==null){ // 로그인 안했을 때
		%>
		<script>
			//alert("로그인 해주세요.");
			location.href="${path}/viewLogin/loginForm.jsp";
		</script>
		<%
	}else{
		%>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<div class="container">

   <div class="row">
    <div class="col-md-8">
      <section>      
        <h3 class="entry-title" style="text-align: center"><span>회원 정보</span> </h3>
        <hr style="border:solid 2px lightgreen">
            <form class="form-horizontal" method="post" name="signUp" id="signUp">    
                
        <div class="form-group">
          <label class="control-label col-sm-3">ID <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
             <div class="input-group">
              <input type="text" class="form-control" name="id" id="id" placeholder="your ID" value="${sessionScope.loginId}" readonly="readonly">
            </div>
           </div>
        </div>
        
        <div class="form-group">
          <label class="control-label col-sm-3">비밀번호(Password) <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="password" id="password" placeholder="8자 이상, 특수문자 포함" value="${memberPw}" readonly="readonly">
           </div>   
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-3">비밀번호 확인 <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="passwordChk" id="passwordChk" placeholder="비밀번호를 확인하세요" value="${memberPw}" readonly="readonly">
            </div>  
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">이름 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="name" id="name" value="${memberName}" readonly="readonly">
          </div>
        </div>

        
        <div class="form-group">
          <label class="control-label col-sm-3">생년월일 <span class="text-danger">*</span></label>
          <div class="col-xs-8">
            <div class="form-inline">
              <div class="form-group">
              	<input type="text" class="form-control" name="birthday" id="birthday" value="${memberBirth}" readonly="readonly">              
              </div>
            </div>
          </div>
        </div>
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">성별 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
          	<c:choose>
			<c:when test="${memberGender}='m'">
				<input type="radio" name="gender" readonly="readonly" checked>남성
			</c:when>
			<c:otherwise>
				<input type="radio" name="gender" readonly="readonly" checked>여성
			</c:otherwise>
			</c:choose>
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">전화번호 <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
             <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
              <input type="text" class="form-control" name="phone" id="phone" value="${memberPhone}" readonly="readonly">
            </div>
            <small>"-"를 빼고 숫자만 넣어주세요.</small>
          </div>
        </div>
        
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">E-Mail <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input type="text" class="form-control" name="email" id="email" placeholder="your EMAIL" value="${memberEmail}" readonly="readonly">
            </div>
             <small>@를 반드시 포함시켜주세요.</small>
           </div>
        </div>
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">아이디 찾기 질문 <span class="text-danger">*</span></label>
          
            <div class="form-inline">
              <div class="col-md-8 col-sm-9">
              <div class="form-group">
              	<input type="text" class="form-control" name="question" id="question" value="${memberQuestion}" readonly="readonly">
                <%-- <select name="mm" class="form-control">
                  <option value="">${memberQuestion}</option>
                  <!-- <option value="1">당신의 이름은 무엇입니까?</option>
                  <option value="2">당신이 태어난 곳은?</option>   -->
                  </select> --%>
              </div>
             </div>
            </div>
          
        </div>
        
        
        
         <div class="form-group">
          <label class="control-label col-sm-3">질문 대답 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="answer" id="answer" placeholder="Enter your Name here" value="${memberAnswer}" readonly="readonly">
          </div>
        </div>
       
         
        <hr style="border:solid 2px lightgreen">
        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10">
          	<input type="button" value="수정하기"  id="update" class="btn"/>
			<input type="button" value="탈퇴하기" id="leave" class="btn"/>
            <!-- <input name="Submit" type="submit" value="가입" class="btn btn-success"> -->
          </div>
        </div>
      </form>
    </div>
    
</div>
</div>
   
<%
	}
%>   

</body>
</html>