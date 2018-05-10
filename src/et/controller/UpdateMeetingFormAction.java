package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.MeetResDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;


public class UpdateMeetingFormAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EtService etService= new EtServiceImpl();
		ModelAndView mv = new ModelAndView();
		String meetingId = request.getParameter("meetingId");
		System.out.println("meetingId ="+meetingId);
		HttpSession session = request.getSession();
		String loginId =(String)session.getAttribute("loginId");

		MeetResDTO dto;
		boolean flag = false;
		
		try {
			dto = etService.selectById(meetingId, flag,loginId);
			if(dto !=null) {
				request.setAttribute("dto", dto);
				mv.setPath("/viewMeeting/updatePart.jsp");
			}else {
				request.setAttribute("errorMsg", "정보가 없습니다.");
				mv.setPath("/viewError/error.jsp");
				mv.setRedirect(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("/viewError/error.jsp");
		}
		return mv;
	}

}
