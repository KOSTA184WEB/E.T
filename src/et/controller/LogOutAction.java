package et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutAction implements Action {
	//
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();

		// 세션의 정보 모두 지우기
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃 세션지우기 완료");
		
		mv.setRedirect(true);
		mv.setPath("index.html");
		
		return mv;		
	}

}
