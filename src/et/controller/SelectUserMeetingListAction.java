package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.MeetResPartDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;


public class SelectUserMeetingListAction implements Action {
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EtService service = new EtServiceImpl();
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		try {
			List<MeetResPartDTO> userMeetingList = service.selectUpcomingMeeting(loginId);
			request.setAttribute("userMeetingList", userMeetingList);
			
			List<MeetResPartDTO> pastMeetingList = service.selectPastMeeting(loginId);
			request.setAttribute("pastMeetingList", pastMeetingList);
		
		}catch(SQLException e) {
			e.printStackTrace();		
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("viewMyPage/userMeetingListView.jsp");
		
		return mv;
	}

}
