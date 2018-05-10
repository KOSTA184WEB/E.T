package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class LeaveMeetingAction implements Action {

	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		String participantId = request.getParameter("participantId");
		System.out.println("participantId : " + participantId);
		
		EtService service = new EtServiceImpl();
	
		ModelAndView mv = new ModelAndView();
		
		try {
			service.cancelMeeting(loginId, participantId);
			mv.setRedirect(true);
			mv.setPath("ET?command=userMeetingList");
			
/*			PrintWriter out = response.getWriter();
			//out.println(result);
*/			
			//request.setAttribute("result", result);
					
		}catch(SQLException e){
			e.printStackTrace();		
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		return mv;
	}

}
