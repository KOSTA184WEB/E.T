package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class InsertReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String memberId=(String)session.getAttribute("loginId");
		//String memberId=request.getParameter("memberId");
		//System.out.println("memberId:"+memberId);
		
		String resId = request.getParameter("resId");
		//System.out.println("resId : "+resId);
		
		ModelAndView mv = new ModelAndView();
		try {
			//유효성 체크
			if(memberId==null) {
				throw new SQLException("입력값이 충분하지 않습니다");
			}
			EtService etService = new EtServiceImpl();
			List<String> list = etService.selectMeetingsById(memberId);//사용자가 참가한 모임...
			List<List<String>> meetList = new ArrayList<>();
			
			meetList.add(list);
			
			
			List<String> titleList = new ArrayList<>();
			for(String meetingId : list) {
				String meetingTitle = etService.selectMeetingTitle(meetingId);

				titleList.add(meetingTitle);
			}
			meetList.add(titleList);
			if(titleList==null) {
				throw new SQLException("참여한 모임이 없습니다");
			}else {
				request.setAttribute("memberId", memberId);
				request.setAttribute("meetList", meetList);
				
				mv.setPath("viewReview/createReviewView.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		return mv;
	}

}
