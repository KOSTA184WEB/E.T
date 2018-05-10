<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>

@import url(http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700);
@import url(http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700);

body {
    background: #fff;
   font-family: 'Roboto', sans-serif;
   color:#333;
   line-height: 22px;   
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

</head>
<body>





<div class="container">
   <div class="row">
    <div class="col-md-8">
      <section>      
        <h1 class="entry-title"><span>회원가입</span> </h1>
        <hr style="border:solid 2px lightgreen">
          <form class="form-horizontal" method="post" name="inForm" id="inForm" action="${pageContext.request.contextPath}/ET?command=insertMember">    
                
        <div class="form-group">
          <label class="control-label col-sm-3">ID <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
             <div class="input-group">
              <input type="text" class="form-control" name="id" id="id" placeholder="your ID" value="">
            </div>
           </div>
        </div>
        
        <div class="form-group">
          <label class="control-label col-sm-3">비밀번호(Password) <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="pw" id="pw" placeholder="8자 이상, 특수문자 포함" value="">
           </div>   
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-3">비밀번호 확인 <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="pwch" id="pwch" placeholder="비밀번호를 확인하세요" value="">
            </div>  
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">이름 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="name" id="name" placeholder="이름을 넣어주세요." value="">
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">생년월일 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
             <div class="input-group">
              <input type="text" class="form-control" name="birth" id="birth" placeholder="ex)19990208" value="">
            </div>
            <small>"-"를 빼고 숫자만 넣어주세요.</small>
           </div>
        </div>
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">성별 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <label>
            <input name="gender" type="radio" value="M" checked>
               남성 </label>
               
            <label>
            <input name="gender" type="radio" value="F" >
               여성 </label>
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">전화번호 <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
             <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
              <input type="text" class="form-control" name="phone" id="phone" placeholder="ex)01033332222" value="">
            </div>
            <small>"-"를 빼고 숫자만 넣어주세요.</small>
          </div>
        </div>
        
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">E-Mail <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input type="text" class="form-control" name="email" id="email" placeholder="your EMAIL" value="">
            </div>
             <small>@를 반드시 포함시켜주세요.</small>
           </div>
        </div>
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">아이디 찾기 질문 <span class="text-danger">*</span></label>
          
            <div class="form-inline">
              <div class="col-md-8 col-sm-9">
              <div class="form-group">
                <select name="ask" id="ask" class="form-control">
                  <option value="">--질문선택--</option>
                  <option value="당신의 이름은 무엇입니까?">당신의 이름은 무엇입니까?</option>
                  <option value="당신이 태어난 곳은?">당신이 태어난 곳은?</option>  
                  </select>
              </div>
             </div>
            </div>
          
        </div>
        
        
        
         <div class="form-group">
          <label class="control-label col-sm-3">질문 대답 <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="answ" id="answ" placeholder="Enter your Name here" value="">
          </div>
        </div>
       
        
        
        <div class="form-group">
          <div class="col-xs-offset-3 col-md-8 col-sm-9"><span class="text-muted"><span class="label label-danger">주의:-</span> 가입과 동시에 회사의 약관에 동의하시는 것으로 간주됩니다.(거부불가) <a href="#">회사약관</a> 반드시 읽어주세요. </span> </div>
        </div>
        
        <hr style="border:solid 2px lightgreen">
        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10">
            <input name="Submit" type="submit" value="가입" class="btn btn-success">
          </div>
        </div>
      </form>
    </div>
</div>
</div>
   
   

</body>
</html>