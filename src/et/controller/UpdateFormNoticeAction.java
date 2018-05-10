package et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class UpdateFormNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeId=request.getParameter("noticeId");
		
		ModelAndView mv = new ModelAndView();
		
		EtService etService = new EtServiceImpl();
		return mv;
	}

}
