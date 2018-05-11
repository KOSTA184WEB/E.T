package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import et.model.dao.ParticipatingDAO;
import et.model.dto.ParticipantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class MeetAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		
		String meetingId = request.getParameter("meetingId");
		String loginId =(String)session.getAttribute("loginId");
		
		ParticipantDTO dto = new ParticipantDTO(null, loginId, meetingId, "N");
		
		PrintWriter out = response.getWriter();
		
		
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		
		try {
			int result = etService.insertParticipant(dto,loginId);
			
			if(result >0) {
				mv.setPath("ET?command=selectParticipating");
				mv.setRedirect(true);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		return mv;
	}

}
