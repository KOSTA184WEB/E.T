<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../css/isotope.css"
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



	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">

				<div class="widget search">
					<form class="form-inline" method="post"
						action="<%=request.getContextPath()%>/hotPlaceServlet">
						<input type="text" name="keyWord" class="form-control search_box"
							placeholder="Search Here"> <input type="submit"
							class="btn btn-primary readmore" value="검색">
					</form>

				</div>
				<!--/.search-->

			</div>



			<div class="col-md-4 com-md-push-2">
				<div class="map">


					<!-- 지도 api -->


					<div id="map" style="width: 100%; height: 450px;"></div>


					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=779796c8968dbb8899ad08ac6df44887"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
   						 mapOption = { 
       					 center: new daum.maps.LatLng(37.5665350, 126.9779690), // 지도의 중심좌표
       					 level: 13 // 지도의 확대 레벨
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
						for(i=0; i<aj.item.length; i++){
							var a = eval(aj.item[i]);
							console.log(a.lat+","+ a.lng);
							//addMarker(new daum.maps.LatLng(a.lat, a.lng));
							
							var marker = new daum.maps.Marker({
								map : map,
								position : new daum.maps.LatLng(a.lat, a.lng)
							})
							
							console.log(a.resName);
							
							var infowindow = new daum.maps.InfoWindow({
						        content: '<div><a>'+a.resName+'</a></div>' // 인포윈도우에 표시할 내용
						    })
							
							daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
						    daum.maps.event.addListener(marker,'click', function(){
						    	alert(2);
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