package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.MeetResDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UpdateMeetingServlet
 */
@WebServlet("/updateMeetingServlet")
public class UpdateMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		String meetingId = request.getParameter("meetingId");
		System.out.println("test="+meetingId);
		String flag= request.getParameter("flag");
		HttpSession session = request.getSession();
		String loginId =(String)session.getAttribute("loginId");
		
		boolean state = false;
		if(flag==null) state=true;
		
		EtService etService = new EtServiceImpl();
		List<MeetResDTO> list = new ArrayList<>();
		try {
			MeetResDTO dto = etService.selectById(meetingId,state,loginId);
		
			if(dto!=null) {
				request.setAttribute("dto", dto);
				list.add(dto);
				JSONArray jsonArr = JSONArray.fromObject(list);
				PrintWriter out = response.getWriter();
				out.println(jsonArr);

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
