package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class DeleteNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeId = request.getParameter("noticeId");
		System.out.println("delete도착!!!!!!!!!!!");
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		try {
			if(noticeId==null) {
				throw new SQLException("정보가 정확하지않습니다");
			}
			
			int re=etService.deleteNotice(noticeId);
			
			if(re>0) {
				mv.setPath("ET?command=listNotice");
				mv.setRedirect(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
