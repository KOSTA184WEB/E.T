package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dao.ParticipatingDAO;
import et.model.dto.ParticipantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class MeetAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getSession().getId();
		String meetingId = request.getParameter("meetingId");
		ParticipantDTO dto = new ParticipantDTO("10", "m1", meetingId, "N",1);
		System.out.println(id+meetingId);
		
		
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		
		try {
			int result = etService.insertParticipant(dto);
			System.out.println("action:"+ result);
			
			if(result >0) {
				mv.setPath("ET");
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
