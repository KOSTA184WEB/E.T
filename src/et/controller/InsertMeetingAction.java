package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.MeetingDTO;
import et.model.dto.RestaurantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class InsertMeetingAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		mv.setPath("viewMeeting/meetingIntro.html");
		mv.setRedirect(true);
		EtService etService = new EtServiceImpl();
		//지도에서 레스토랑 정보를 받아와서 등록여부 판단한 후 레스토랑 등록   
		String meetLoc = request.getParameter("meetLocKeyWord");
		String resName = request.getParameter("resName");
		
		
		RestaurantDTO resDto = new RestaurantDTO();
		//레스토랑 주소로 레스토랑 등록 여부 검색하는 메소드
		
		//RestaurantDTO res = new RestaurantDTO(resId, resName, resKind, resAddress, resPhone, resRate, lat, lng, meetingCount);
		///////////////////////////////////// 지도 api 이용하여 위도 경도 주소 등 res정보 가져와서 등록
		/////////////////////////////////////		
		
		
		String maxNum = request.getParameter("maxNum");
		String genderOption = request.getParameter("genderOption");
		String meetDate = request.getParameter("meetDate");
		String meetTime = request.getParameter("meetTime");
		String meetDescription = request.getParameter("meetDescription");
		String menu  = request.getParameter("menu");
		String meetingTitle = request.getParameter("meetingTitle");

		String meetingDate = meetDate + meetTime;
		
		MeetingDTO meetingDto = new MeetingDTO(null,null,resDto.getResId(),null,menu,maxNum,meetingDate,null,meetDescription,meetingTitle,genderOption);
		
		
		System.out.println(meetLoc);
		
		try {
			etService.insertRestaurant(resDto);
			etService.insertMeeting(meetingDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mv;
	}

}
