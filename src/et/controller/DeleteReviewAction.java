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
			//��ȿ��üũ
			if(reviewId==null || reviewPw==null) {
				throw new SQLException("������ ��Ȯ���� �ʽ��ϴ�");
			}
			
			//��й�ȣ Ȯ��
			EtService etService = new EtServiceImpl();
			ReviewDTO revDto =  etService.selectReview(reviewId, false); //��ȸ������X
			
			if(revDto.getReviewPw().equals(reviewPw)) {
				int re= etService.deleteReview(reviewId, reviewPw);
				if(re>0) {
					mv.setPath("ET?command=listReview");
					mv.setRedirect(true);
				}
			}else {//��й�ȣ ����
				throw new SQLException("��й�ȣ�� Ȯ�����ּ���");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
