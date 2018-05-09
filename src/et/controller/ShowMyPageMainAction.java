package et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMyPageMainAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("viewMyPage/myPageMainView.jsp");
		
		return mv;
	}

}
