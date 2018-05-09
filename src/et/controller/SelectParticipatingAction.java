package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.MeetingDTO;
import et.model.dto.ParticipantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class SelectParticipatingAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("¾È³ç");
		EtService etService = new EtServiceImpl();
		ModelAndView mv = new ModelAndView();
		List<MeetingDTO> list;
		try {
			list = etService.selectAllPart();
			request.setAttribute("list", list);
			mv.setPath("/viewMeeting/participate.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("/viewError/error.jsp");
			}
		return mv;
	}

}
