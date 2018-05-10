<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

/* Style the tab */
.tab {
    float: left;
   /*  border: 1px solid #ccc; */
    background-color: white;
    width: 15%;
	/* height: 300px; */
 	padding: 40px 10px;
}

/* Style the buttons that are used to open the tab content */
.tab button {
    display: block;
    background-color: inherit;
    color: black;
    padding: 22px 16px;
    width: 100%;
    border: none;
    outline: none;
    text-align: left;
    cursor: pointer;
    transition: 0.3s;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #E3F6CE; /*색 사이트 컬러로 바꾸기!!*/
}

/* Create an active/current "tab button" class */
.tab button.active {
    background-color: #D0F5A9; /*색 사이트 컬러로 바꾸기!!*/
}

/* Style the tab content */
.tabcontent {
    float: left;
    padding: 40px 10px;
    /* border: 1px solid #ccc; */
    width: 80%;
    border-left: none;
    height: 100%;
}
</style>

<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function openCategory(evt, category) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
     tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
     document.getElementById(category).style.display = "block";
     evt.currentTarget.className += " active";
}
</script>

<title>Insert title here</title>
</head>
<body>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<div class="tab">
  <button class="tablinks" onclick="openCategory(event, 'myInfo')" style="text-align: center;font-size:medium;">MY INFO</button>
  <button class="tablinks" onclick="openCategory(event, 'myMeeting')" style="text-align: center;font-size:medium;">MY MEETING</button>
  <button class="tablinks" onclick="openCategory(event, 'myDeposit')" style="text-align: center;font-size:medium;">MY SPOON</button>
</div>


<div id="myInfo" class="tabcontent">	
  	<iframe src="${path}/ET?command=showUserInfo" width=100% height="600px" frameborder="no">
	</iframe>

</div>

<div id="myMeeting" class="tabcontent">
  	<iframe src="${path}/ET?command=userMeetingList" width=100% height="600px" frameborder="no">
  	</iframe>

</div>

<div id="myDeposit" class="tabcontent">
 	 <iframe src="${path}/ET?command=depositList" width=100% height="600px" frameborder="no">
	 </iframe>

</div>


</body>
</html>