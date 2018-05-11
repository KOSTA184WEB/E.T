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

public class ReadPartAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String meetingId = request.getParameter("meetingId");
		String flag= request.getParameter("flag");
		HttpSession session = request.getSession();
		String loginId =(String)session.getAttribute("loginId");

		boolean state = false;
		if(flag==null) state=true;
		
		EtService etService = new EtServiceImpl();
		ModelAndView mv = new ModelAndView();
		
		try {
			MeetResDTO dto = etService.selectById(meetingId,state,loginId);
			/*int check = etService.meetingCheck(meetingId, loginId);
			if(check==1) {
				request.setAttribute("check", check);
			}
*/
			
			if(dto!=null) {
				request.setAttribute("dto", dto);
				mv.setPath("viewMeeting/readPart.jsp");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("viewError/error.jsp");
		}
		
		
		return mv;
	}

}
