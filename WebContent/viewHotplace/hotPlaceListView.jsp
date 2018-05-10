<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../css/isotope.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css"
	type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<style>
#searchBar {
	postition: relative;
	top: 150px;
	left: 150px;
}
</style>

</head>
<body>

	<header>
		<%@ include file="../header.jsp"%>
	</header>



	<div class="container-fluid">
		<div class="row">

			<div class="col-md-6" id="searchBar">
				<div class="widget search">
					<form class="form-inline" method="post"
						action="<%=request.getContextPath()%>/ET?command=hotplace">
						<input type="text" name="keyWord" class="form-control search_box"
							placeholder="Search Here"> <input type="submit"
							class="btn btn-success readmore" value="검색">
					</form>

				</div>
				<!--/.search-->
			</div>






			<div class="col-md-6 col-xs-pull-2">
				<div class="map">


					<!-- 지도 api -->


					<div id="map" style="width: 100%; height: 450px;"></div>


					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=779796c8968dbb8899ad08ac6df44887"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
   						 mapOption = { 
       					 center: new daum.maps.LatLng(37.40204, 127.10722), // 지도의 중심좌표
       					 level: 11 // 지도의 확대 레벨
   							 };

						var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
						
						// 지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
						/* daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
						    // 클릭한 위치에 마커를 표시합니다 
						    addMarker(mouseEvent.latLng);             
						}); */
						
						
						var markers = [];
						
						// 마커를 생성하고 지도위에 표시하는 함수입니다
						function addMarker(position) {
						    console.log("position : " + position)
						    // 마커를 생성합니다
						    var marker = new daum.maps.Marker({
						        position: position
						    });
						
						    // 마커가 지도 위에 표시되도록 설정합니다
						    marker.setMap(map);
						    
						    // 생성된 마커를 배열에 추가합니다
						    markers.push(marker);
						}
						
						// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
						function setMarkers(map) {
						    for (var i = 0; i < markers.length; i++) {
						        markers[i].setMap(map);
						    }            
						}
						
						// "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
						function showMarkers() {
						    setMarkers(map)    
						}
						
						// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
						function hideMarkers() {
						    setMarkers(null);    
						}
						
						
						
						
						
						
						var aj = eval(<%=request.getAttribute("obj")%>);
						var path = "<%=request.getContextPath()%>";
						for (i = 0; i < aj.item.length; i++) {
							var a = eval(aj.item[i]);
							console.log(a.lat + "," + a.lng);
							//addMarker(new daum.maps.LatLng(a.lat, a.lng));

							marker = new daum.maps.Marker({
								map : map,
								position : new daum.maps.LatLng(a.lat, a.lng)
							})

							console.log(a.resName);

							var infowindow = new daum.maps.InfoWindow({
								content : "<div><a id='resName'>" + a.resName
										+ '</a></div>' // 인포윈도우에 표시할 내용
							})

							daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
							daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
							daum.maps.event.addListener(marker, 'click', function() {
												
								$(function() {

									function selectAll() {
										$.ajax({
											type : "post",
											url : path + "/markerServlet",
											data : "resName=" + $('#resName').text(), //서버에게 보낼 parameter 정보
											dataType : "json", //서버가 front로 보내주는 데이터 타입 (text ,html, xml, json)
											success : function(result) {
												$.each(result, function(index, item) {
													document.getElementById("info1").innerHTML = "<a><font color='blue'>" + item.resId + "</font></a>";
													document.getElementById("info2").innerHTML = "<a><font color='blue'>" + item.resName + "</font></a>";
													document.getElementById("info3").innerHTML = "<a><font color='blue'>" + item.resKind + "</font></a>";
													document.getElementById("info4").innerHTML = "<a><font color='blue'>" + item.resAddress + "</font></a>";
													document.getElementById("info5").innerHTML = "<a><font color='blue'>" + item.resPhone + "</font></a>";
													document.getElementById("info6").innerHTML = "<a><font color='red'>" + item.resRate + "/ 5" + "</font></a>";
													document.getElementById("info7").innerHTML = "<a><font color='blue'>" + item.lat + "</font></a>";
													document.getElementById("info8").innerHTML = "<a><font color='blue'>" + item.lng + "</font></a>";
													document.getElementById("info9").innerHTML = "<a><font color='blue'>" + item.meetingCount + "</font></a>";
												})

											}, error : function(err) {
													console.log("에러 발생 : " + err);
											}
										});

									}

										selectAll();

								});

							});
						}

						// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
						function makeOverListener(map, marker, infowindow) {
							return function() {
								infowindow.open(map, marker);
							};
						}

						// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
						function makeOutListener(infowindow) {
							return function() {
								infowindow.close();
							};
						}
					</script>


				</div>
			</div>

		</div>
	</div>

	<hr style="border: 1px solid gray">

	<div class="container-fluid">
		<div class="col-md-7 col-md-push-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">식당 정보</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td class="text-center gr" width="200px"><strong><a>식당번호</a></strong>
									</td>
									<td id="info1"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>식당이름</a></strong></td>
									<td id="info2"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>업종</a></strong></td>
									<td id="info3"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>주소</a></strong></td>
									<td id="info4"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>전화번호</a></strong></td>
									<td id="info5"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>평점</a></strong></td>
									<td id="info6"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>위도</a></strong></td>
									<td id="info7"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>경도</a></strong></td>
									<td id="info8"></td>
								</tr>
								<tr>
									<td class="text-center gr"><strong><a>모임횟수</a></strong></td>
									<td id="info9"></td>
								</tr>
							</tbody>
						</table>
						
						<div class="col-xs-3 col-xs-push-5">
							<input type="button" class="btn btn-info btn-sm" href="" value="모집하러 가기~">
							<input type="button" class="btn btn-danger btn-sm" href="" value="참여하러 가기~">
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>










	<footer>
		<%@ include file="../footer.jsp"%>
	</footer>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.pack.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/functions.js"></script>
	<script>
		wow = new WOW({

		}).init();
	</script>





</body>
</html>