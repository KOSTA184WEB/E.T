package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class AdminDeleteReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		System.out.println("����");
		String reviewId= request.getParameter("reviewId");
		System.out.println("reviewId :"+reviewId);
		try {
			//��ȿ��üũ
			if(reviewId==null) {
				throw new SQLException("������ ��Ȯ���� �ʽ��ϴ�");
			}
			
			EtService etService = new EtServiceImpl();
			int re= etService.AdminDeleteReview(reviewId);
			if(re>0) {
					mv.setPath("ET?command=listReview");
					mv.setRedirect(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
