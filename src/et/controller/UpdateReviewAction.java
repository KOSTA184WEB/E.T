package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class UpdateReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv= new ModelAndView();
		
		HttpSession session = request.getSession();
		
		EtService etService = new EtServiceImpl();
		
		String memberId=(String)session.getAttribute("loginId");
		String meetingId = request.getParameter("meetListId");
		String reviewId = request.getParameter("reviewId");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		String reviewPw = request.getParameter("reviewPw");
		String resId=null;
		try {
			resId = etService.selectRestaurantId(meetingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println("resId: "+resId);
		try {
			//유효성 체크
			if(meetingId==null || reviewId==null ||reviewTitle==null ||reviewContents==null || reviewPw==null) {
				throw new SQLException("입력값이 충분하지 않습니다");
			}
			
			//비밀번호체크
			ReviewDTO revDto =  etService.selectReview(reviewId, false); //조회수증가X
			
			if(revDto.getReviewPw().equals(reviewPw)) {
				ReviewDTO reviewDto = new ReviewDTO(reviewId, memberId, meetingId, resId, reviewTitle, reviewContents, reviewPw);
				int re = etService.updateReview(reviewDto);
				
				mv.setPath("ET?command=detailReview&flag=1&reviewId="+reviewId+"&meetingId="+meetingId);
			}else {//비밀번호 오류
				throw new SQLException("비밀번호를 다시 확인해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
