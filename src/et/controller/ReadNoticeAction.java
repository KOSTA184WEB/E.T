package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.NoticeDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class ReadNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		
		String noticeId = request.getParameter("noticeId");
		String flag = request.getParameter("flag"); //수정이 완료된후 전달된다
		
		boolean state=false;
		if(flag==null) {//전달안됨
			state=true; //list에서 제목을 클릭했을때 상황
		}
		
		try {
			NoticeDTO noticeDTO = etService.selectNotice(noticeId, state);
			
			request.setAttribute("noticeDTO", noticeDTO);
			
			mv.setPath("viewNotice/detailNoticeView.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		
		return mv;
	}

}
