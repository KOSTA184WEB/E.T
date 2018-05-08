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
		mv.setPath("viewMeeting/createMeeting.jsp");
		EtService etService = new EtServiceImpl();
		// �������� ������� ������ �޾ƿͼ� ���񽺷� ���� (service���� ��Ͽ��� �Ǵ��� �� ������� ���)
		String resName = request.getParameter("resName");
		String resAddr = request.getParameter("resAddr");
		String resPhone = request.getParameter("resPhone");
		String resKind = request.getParameter("resKind");
		String resLat = request.getParameter("resLat");
		String resLng = request.getParameter("resLng");
		RestaurantDTO resDto = new RestaurantDTO(null, resName, resKind, resAddr, resPhone, 0, Double.parseDouble(resLat), Double.parseDouble(resLng), 0);
		
		System.out.println(resName + " | " + resAddr + " | " + resPhone + " | " + resKind + " | " + resLat + " | " + resLng + " | ");

		String maxNum = request.getParameter("maxNum");
		String genderOption = request.getParameter("genderOption");
		String meetDate = request.getParameter("meetDate");
		String meetTime = request.getParameter("meetTime");
		String meetDescription = request.getParameter("meetDescription");
		String meetingTitle = request.getParameter("meetingTitle");

		String meetingDate = meetDate + meetTime;

		MeetingDTO meetingDto = new MeetingDTO(null, null, resDto.getResId(), 0, resKind, Integer.parseInt(maxNum), meetingDate, null, meetDescription,
				meetingTitle, genderOption);

		try {
			etService.insertRestaurant(resDto);
			String resId = etService.searchResIdByAddr(resDto.getResAddress());
			meetingDto.setResId(resId);
			etService.insertMeeting(meetingDto);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("create", "y");
		return mv;
	}

}
