package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class ReadReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		String flag = request.getParameter("flag"); //수정이 완료된후 전달된다
		
		boolean state=false;
		if(flag==null) {//전달안됨
			state=true; //list에서 제목을 클릭했을때 상황
		}
		
		String meetingId=request.getParameter("meetingId");
		
		String reviewID=request.getParameter("reviewId");
		System.out.println("read meetingId :"+meetingId);
		try {
			EtService etService = new EtServiceImpl();
			
			ReviewDTO reviewDto = etService.selectReview(reviewID, state);
			
			String resId=etService.selectRestaurantId(meetingId);
			String meetingTitle=etService.selectMeetingTitle(meetingId);
			int resRate = etService.selectRestaurantRate(resId);
			String resKind = etService.selectRestaurantKind(resId);
			String meetingDate = etService.selectMeetingDate(meetingId);
			
			request.setAttribute("resRate", resRate);
			request.setAttribute("resKind", resKind);
			request.setAttribute("meetingDate", meetingDate);
			request.setAttribute("meetingTitle", meetingTitle);
			request.setAttribute("reviewDto", reviewDto);
			
			mv.setPath("viewReview/detailReviewView.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
