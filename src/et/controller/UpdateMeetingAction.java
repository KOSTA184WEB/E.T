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

public class UpdateMeetingAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		mv.setPath("viewMeeting/meetingForm.jsp");
		EtService etService = new EtServiceImpl();
		// 지도에서 레스토랑 정보를 받아와서 서비스로 전달 (service에서 등록여부 판단한 후 레스토랑 등록)
		String inputResAddr = request.getParameter("resAddr");
		
		
		String resName = request.getParameter("resName");
		String resPhone = request.getParameter("resPhone");
		String resKind = request.getParameter("resKind");
		String resLat = request.getParameter("resLat");
		String resLng = request.getParameter("resLng");
		String meetingId = request.getParameter("meetingId");
		
		RestaurantDTO resDto = new RestaurantDTO(null,resName, resKind, inputResAddr, resPhone, 0, Double.parseDouble(resLat), Double.parseDouble(resLng), 0);
		
		//System.out.println(resName + " | " + resAddr + " | " + resPhone + " | " + resKind + " | " + resLat + " | " + resLng + " | ");

		String maxNum = request.getParameter("maxNum");
		String genderOption = request.getParameter("genderOption");
		String meetDate = request.getParameter("meetDate");
		String []meetDate2 = meetDate.split("/");
		meetDate = meetDate2[2]+meetDate2[0]+meetDate2[1];
		String meetTime = request.getParameter("meetTime");
		String [] meetTime2 = meetTime.split(":");
		meetTime = meetTime2[0]+meetTime2[1]+meetTime2[2];
		String meetDescription = request.getParameter("meetDescription");
		String meetingTitle = request.getParameter("meetingTitle");
		
		
		String meetingDate = meetDate + meetTime;

		MeetingDTO meetingDto = new MeetingDTO(meetingId, null, null, 0, resKind, Integer.parseInt(maxNum), meetingDate, null, meetDescription,
				meetingTitle, genderOption);

		try {
			String resId = etService.searchResIdByAddr(inputResAddr);
			if(resId!=null) {
				String dbResId = etService.searchResIdByMeetingId(meetingId);
				if(!dbResId.equals(resId)) {
					etService.updateResCount(dbResId, false);
					etService.updateResCount(resId,true); //false면 count 감소
					
				}
			}else {
				etService.insertRestaurant(resDto);
				resId=etService.searchResIdByAddr(inputResAddr);
				etService.updateResCount(resId,false); //false면 count 감소
			}
 			meetingDto.setResId(resId);
			int result = etService.updateMeeting(meetingDto);
			if(result>0) {
				mv.setPath("viewMeeting/meetingForm.jsp");
				mv.setRedirect(false);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("update", "y");
		return mv;
	}


}
