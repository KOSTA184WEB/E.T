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


<script type="text/javascript">

function checked()
{
    var idtext = document.getElementById("id");
    //아이디의 id값
    var patext = document.getElementById("pw");
    //비밀번호의 id값
    var cpatext = document.getElementById("pwch");
   //비밀번호확인의 id값
    var mtext = document.getElementById("email");
   //e-mail의 id값
    var nametext = document.getElementById("name");
   //이름의 id값
    var answr =  document.getElementById("answ");
		//아이디 찾기 대답란 id값
		var birthtext =  document.getElementById("birth");
		//생년월일 id값
		var phonetext =  document.getElementById("phone");
		

    var id = idtext.value;
    var password = patext.value;
    var cpassword = cpatext.value;
    var mail = mtext.value;
    var name = nametext.value;
    var birth = birthtext.value;
    var phone = phonetext.value;
   
  
    var regExp1 = /^[a-zA-Z0-9]{4,12}$/;
    //id와 비밀번호의 유효성 검사
    var regExp2 = /^[\w-]{2,}@[\w-]+(\.\w+){1,3}$/;
    //e-mail의 유효성 검사
    var regname = /^[가-힝]{2,}$/;
    //이름의 유효성 검사
    var regnumber = /^\d{8,11}$/;
    //숫자(생년월일, 전화번호) 유효성 검사
    
    if(!regExp1.test(id))
     //아이디 유효성 검사 후 4~12자의 영문 대소문자와 숫자의 유효성이 안 맞다면
     //공백을 주고 알람을 띄운다.
     //밑에 동일한 유효성 검사
    {
        alert("4~12자 이내의 영문이나 숫자를 조합하여 다시 ID를 입력해주세요.");
        idtext.value = "";
        idtext.focus();
        return false;
    }
    else if (!regExp1.test(password))
    {
        alert("4~12자 이내의 영문이나 숫자를 조합하여 다시 비밀번호를 입력해주세요.");
        patext.value = "";
        patext.focus();
        return false;
    } 
    else if (!(cpassword.slice(0, cpassword.length) === password.slice(0, password.length))) 
    {
        alert("비밀번호와 비밀번호 확인의 입력이 동일하지 않습니다.");
        cpatext.value = "";
        cpatext.focus();
        return false;
    } 
    else if ((cpassword.slice(0, cpassword.length) === id.slice(0, id.length))) 
    {
        alert("비밀번호가 ID와 동일하면 안됩니다.");
        patext.value = "";
        patext.focus();
        cpatext.value = "";
        cpatext.focus();
        return false;
    }
    else if (!regname.test(name))
    {
        alert("이름은 2글자 이상 입력하셔야 합니다.");
        nametext.value = "";
        nametext.focus();
        return false;
    }
    else if(birth==""){
    	alert("생년월일을 입력해주세요.");
    	birthtext.focus();
        return false;
    }
    else if (!regnumber.test(birth))
    {
        alert("올바른 생년월일 형식이 아닙니다.");
        birthtext.value = "";
        birthtext.focus();
        return false;
    }
    else if(phone==""){
    	alert("전화번호를 입력해주세요.");
    	phonetext.focus();
        return false;
    }
    else if(!regnumber.test(phone))
    	{
    	alert("잘못된 형식으로 입력하셨습니다.");
        phonetext.value = "";
        phonetext.focus();
        return false;
    	}
    else if (!regExp2.test(mail))
    {
        alert("올바른 이메일 형식이 아닙니다.");
        mtext.value = "";
        mtext.focus();
        return false;
    }
    else if(answr.value==""){
        alert("질문에 대답해주세요");
        answr.focus();
        return false;
     }else 
    	 return true;
}

</script>

<nav class="navbar navbar-default navbar-static-top">
	<div class="navigation">
		<div class="row">
			<div class="col-md-2 col-md-push-2">
		 		<a href="${pageContext.request.contextPath}/viewIntro/intro.jsp"> 
		 			<img src="${pageContext.request.contextPath}/images/ET_Logo.png" style="" width="125px" height="100px">
				</a>
			</div>
		</div>
	</div>
</nav>


<div class="container-fluid">
	<div class="row">
    <div class="col-md-8 col-md-push-2">
      <section>      
        <h1 class="entry-title"><span>회원가입</span> </h1>
        <hr style="border:solid 2px lightgreen">
       	<form class="form-horizontal" method="post" name="inForm" id="inForm" action="${pageContext.request.contextPath}/ET?command=insertMember" onsubmit="return checked();">    
                
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
            <input type="text" class="form-control" name="answ" id="answ" placeholder="" value="">
          </div>
        </div>
       
        
        
        <div class="form-group">
          <div class="col-xs-offset-3 col-md-8 col-sm-9"><span class="text-muted"><span class="label label-danger">주의:-</span style="color:red"> 가입과 동시에 회사의 약관에 동의하시는 것으로 간주됩니다.(거부불가) <a href="#">회사약관</a> 반드시 읽어주세요. </span> </div>
        </div>
        
        <hr style="border:solid 2px lightgreen">
        

        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10">
            <input type="submit" value="가입" class="btn btn-success">
          </div>
        </div>

       
      </form>
    </div>
</div>
</div>
	
	

</body>
</html>