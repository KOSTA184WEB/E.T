<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/isotope.css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
<script>
	function overColor_nav1() {
		var element = document.getElementById("nav1");
		element.style.color = "#4D8923";

	}

	function outColor_nav1() {
		var element = document.getElementById("nav1");
		element.style.color = "#000000";

	}

	function overColor_nav2() {
		var element = document.getElementById("nav2");
		element.style.color = "#4D8923";

	}

	function outColor_nav2() {
		var element = document.getElementById("nav2");
		element.style.color = "#000000";

	}

	function overColor_nav3() {
		var element = document.getElementById("nav3");
		element.style.color = "#4D8923";
	}

	function outColor_nav3() {
		var element = document.getElementById("nav3");
		element.style.color = "#000000";
	}

	function click_nav() {
		alert('로그인 후 이용해주세요.');
		location.href = '#';
	}
	function logout() {
		if (confirm("정말 로그아웃 하시겠습니까?")) {
			location.href = "../ET?command=logout";
		} else {
			alert("로그아웃 취소하셨습니다.");
		}
	}

	function loginOpen() {
		var popupX = (window.screen.width/2) - (500/2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height/2) - (300/2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

		window.open("${pageContext.request.contextPath}/viewLogin/loginForm.jsp", "win", 'status=no, height=300, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		
	}
</script>


<style>
   .form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}

</style>
</head>
<body>
	<%
		if (session.getAttribute("loginId") == null) {
	%>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navigation">
			<div class="container">
				<div class="navbar-header">
					<div class="navbar-brand">
						<a href="${pageContext.request.contextPath}/viewIntro/intro.jsp"> <img src="${pageContext.request.contextPath}/images/ET_Logo.png" width="125px"
							height="100px"
						>
						</a>
					</div>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/viewSignUp/signUpIntro.jsp"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
					<li><a href="#" onclick="loginOpen()"><span class="glyphicon glyphicon-log-in"></span> LogIn</a></li>
				</ul>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs navbar-right">
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li role="presentation"><a id="nav" href="${pageContext.request.contextPath}/viewAboutUs/AboutUs.jsp"><font color="#4D8923">About US</font></a></li>

							<li role="presentation"><a id="nav1" href="${pageContext.request.contextPath}/viewMeeting/meetingIntro.jsp"  onmouseover="overColor_nav1()" onmouseout="outColor_nav1()">Meet</a></li>
							<li role="presentation"><a id="nav2" onclick="click_nav()"  onmouseover="overColor_nav2()" onmouseout="outColor_nav2()">Rate</a></li>
							<li role="presentation"><a id="nav3" href="${pageContext.request.contextPath}/viewLogin/loginForm.jsp" onmouseover="overColor_nav3()" onmouseout="outColor_nav3()">MyPage</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<%
		} else {
	%>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navigation">
			<div class="container">
				<div class="navbar-header">
					<div class="navbar-brand">
						<a href="${pageContext.request.contextPath}/viewIntro/intro.jsp"> <img src="${pageContext.request.contextPath}/images/ET_Logo.png" width="125px"
							height="100px"
						>
						</a>
					</div>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a><span class="glyphicon glyphicon-user">&nbsp;</span><%=session.getAttribute("loginId")%> 님 즐거운 식사 되세요!</a></li>
					<li><a href="#" onclick="logout()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs navbar-right">
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li><a></a></li>
							<li role="presentation"><a href="../viewAboutUs/AboutUs.jsp"><font color="#4D8923">About US</font></a></li>
							<li role="presentation"><a id="nav1" href="${pageContext.request.contextPath}/viewMeeting/meetingIntro.jsp" onmouseover="overColor_nav1()" onmouseout="outColor_nav1()">Meet</a></li>
							<li role="presentation"><a id="nav2" href="board.jsp" onmouseover="overColor_nav2()" onmouseout="outColor_nav2()">Rate</a></li>
							<li role="presentation"><a id="nav3" href="${pageContext.request.contextPath}/viewMyPage/myPageIntro.jsp" onmouseover="overColor_nav3()" onmouseout="outColor_nav3()">MyPage</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<%
		}
	%>
   <%
      if (session.getAttribute("loginId") == null) {
   %>
   <nav class="navbar navbar-default navbar-static-top">
      <div class="navigation">
         <div class="container">
            <div class="navbar-header">
               <div class="navbar-brand">
                  <a href="${pageContext.request.contextPath}/viewIntro/intro.jsp"> <img src="${pageContext.request.contextPath}/images/ET_Logo.png" width="125px"
                     height="100px"
                  >
                  </a>
               </div>
            </div>
            <ul class="nav navbar-nav navbar-right">
               <li><a href="${pageContext.request.contextPath}/viewSignUp/signUpIntro.jsp"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
               <li><a href="#myModal" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> LogIn</a></li>
            </ul>
            <div class="navbar-collapse collapse">
               <div class="menu">
                  <ul class="nav nav-tabs navbar-right">
                     <li><div></div></li>
                     <li><div></div></li>
                     <li><div></div></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li role="presentation"><a id="nav" href="${pageContext.request.contextPath}/viewAboutUs/AboutUs.jsp"><font color="#4D8923">About US</font></a></li>
                     <li role="presentation"><a id="nav1" href="${pageContext.request.contextPath}/viewMeeting/meetingIntro.jsp"  onmouseover="overColor_nav1()" onmouseout="outColor_nav1()">Meet</a></li>
                     <li role="presentation"><a id="nav2" onclick="click_nav()"  onmouseover="overColor_nav2()" onmouseout="outColor_nav2()">Rate</a></li>
                     <li role="presentation"><a id="nav3" href="${pageContext.request.contextPath}/viewLogin/loginForm.jsp" onmouseover="overColor_nav3()" onmouseout="outColor_nav3()">MyPage</a></li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </nav>
   
   
   
   <!-- Modal -->
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
               
            <div class="modal-body">
               <div class="container">
                   <div class="row">
                    <div class="col-sm-6">
                           <div class="account-wall">
                               <center><img src="${pageContext.request.contextPath}/images/ET_Logo.png" style="width:150px;height:100px;"></center>
                   <form class="form-signin" method="post" action="${pageContext.request.contextPath}/ET?command=login">
                      <input type="text" name="memberId" class="form-control" placeholder="ID" required autofocus>
                      <input type="password" name="memberPw" class="form-control" placeholder="Password" required>
                      <button class="btn btn-lg btn-success btn-block" type="submit">
                          로그인</button>
                   </form>
                    </div>
                        <a href="${pageContext.request.contextPath}/" class="text-center new-account">같이 드시고 싶으셨쎄여?_(회원가입)</a>
                    </div>
             </div>
         </div>
            
            
            
            
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-success" data-dismiss="modal">닫기</button>
            </div>
          </div> <!-- 모달 콘텐츠 -->
        </div> <!-- 모달 다이얼로그 -->
   </div> <!-- 모달 전체 윈도우 -->
   
   <%
      } else {
   %>
   <nav class="navbar navbar-default navbar-static-top">
      <div class="navigation">
         <div class="container">
            <div class="navbar-header">
               <div class="navbar-brand">
                  <a href="${pageContext.request.contextPath}/viewIntro/intro.jsp"> <img src="${pageContext.request.contextPath}/images/ET_Logo.png" width="125px"
                     height="100px"
                  >
                  </a>
               </div>
            </div>
            <ul class="nav navbar-nav navbar-right">
               <li><a><span class="glyphicon glyphicon-user">&nbsp;</span><%=session.getAttribute("loginId")%> 님 즐거운 식사 되세요!</a></li>
               <li><a href="#" onclick="logout()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
            <div class="navbar-collapse collapse">
               <div class="menu">
                  <ul class="nav nav-tabs navbar-right">
                     <li><div></div></li>
                     <li><div></div></li>
                     <li><div></div></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li><a></a></li>
                     <li role="presentation"><a href="../viewAboutUs/AboutUs.jsp"><font color="#4D8923">About US</font></a></li>
                     <li role="presentation"><a id="nav1" href="${pageContext.request.contextPath}/viewMeeting/meetingIntro.jsp" onmouseover="overColor_nav1()" onmouseout="outColor_nav1()">Meet</a></li>
                     <li role="presentation"><a id="nav2" href="board.jsp" onmouseover="overColor_nav2()" onmouseout="outColor_nav2()">Rate</a></li>
                     <li role="presentation"><a id="nav3" href="${pageContext.request.contextPath}/viewMyPage/myPageIntro.jsp" onmouseover="overColor_nav3()" onmouseout="outColor_nav3()">MyPage</a></li>
                     
                     
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </nav>
   <%
      }
   %>
</body>
</html>