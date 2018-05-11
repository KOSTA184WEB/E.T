package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class DeleteReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		
		String reviewId= request.getParameter("reviewId");
		String reviewPw= request.getParameter("reviewPw");
		
		try {
			//유효성체크
			if(reviewId==null || reviewPw==null) {
				throw new SQLException("정보가 정확하지 않습니다");
			}
			
			//비밀번호 확인
			EtService etService = new EtServiceImpl();
			ReviewDTO revDto =  etService.selectReview(reviewId, false); //조회수증가X
			
			if(revDto.getReviewPw().equals(reviewPw)) {
				int re= etService.deleteReview(reviewId, reviewPw);
				if(re>0) {
					mv.setPath("ET?command=listReview");
					mv.setRedirect(true);
				}
			}else {//비밀번호 오류
				throw new SQLException("비밀번호를 확인해주세요");
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		return mv;
	}

}
