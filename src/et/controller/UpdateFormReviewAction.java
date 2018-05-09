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
		//System.out.println("���");
		String reviewId=request.getParameter("reviewId");
		
		HttpSession session = request.getSession();
		
		String memberId=(String)session.getAttribute("loginId");

		try {
			//��ȿ�� üũ
			if(memberId==null) {
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�");
			}
			if(reviewId==null) {
				throw new SQLException(reviewId+"�� �����ϴ�");
			}
			EtService etService = new EtServiceImpl();
			ReviewDTO reviewDto = etService.selectReview(reviewId, false);
			
			List<String> meetIdList = etService.selectMeetingsById(memberId);//����ڰ� ������ ����...
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
				throw new SQLException("������ ������ �����ϴ�");
			}
			
			if(reviewDto==null) {
				throw new SQLException("�ش��ϴ� �ıⰡ �����ϴ�");
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
