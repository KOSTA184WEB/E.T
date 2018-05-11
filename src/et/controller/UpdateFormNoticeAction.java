package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.NoticeDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class UpdateFormNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		String memberId=(String)session.getAttribute("loginId");
		String noticeId=request.getParameter("noticeId");
		
		EtService etService = new EtServiceImpl();
		
		try {
			NoticeDTO noticeDTO = etService.selectNotice(noticeId, false);
			if(noticeDTO==null) {
				throw new SQLException("해당공지가 없습니다");
			}else {
				request.setAttribute("noticeDTO", noticeDTO);
				mv.setPath("viewNotice/updateNoticeView.jsp");//forward방식
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		return mv;
	}

}
