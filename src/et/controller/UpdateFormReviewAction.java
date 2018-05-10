package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;


public class UpdateFormReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		//System.out.println("출력");
		String reviewId=request.getParameter("reviewId");
		
		HttpSession session = request.getSession();
		
		String memberId=(String)session.getAttribute("loginId");

		try {
			//유효성 체크
			if(memberId==null) {
				throw new SQLException("입력값이 충분하지 않습니다");
			}
			if(reviewId==null) {
				throw new SQLException(reviewId+"이 없습니다");
			}
			EtService etService = new EtServiceImpl();
			ReviewDTO reviewDto = etService.selectReview(reviewId, false);
			
			List<String> meetIdList = etService.selectMeetingsById(memberId);//사용자가 참가한 모임...
			List<List<String>> meetList = new ArrayList<>();
			
			meetList.add(meetIdList);
			//System.out.println("meetIdList : "+meetIdList);
			
			List<String> titleList = new ArrayList<>();
			for(String meetingId : meetIdList) {
				String meetingTitle = etService.selectMeetingTitle(meetingId);

				titleList.add(meetingTitle);
			}
			meetList.add(titleList);
			//System.out.println("titleList : "+titleList);
			if(titleList==null) {
				throw new SQLException("참여한 모임이 없습니다");
			}
			
			if(reviewDto==null) {
				throw new SQLException("해당하는 후기가 없습니다");
			}else {
				
				//System.out.println("reviewDto: "+ reviewDto);
				request.setAttribute("reviewDto", reviewDto);
				request.setAttribute("meetList", meetList);
			
				mv.setPath("viewReview/updateReviewView.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}

}
