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

		// ������ ���� ��� �����
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("�α׾ƿ� ��������� �Ϸ�");
		
		mv.setRedirect(true);
		mv.setPath("index.html");
		
		return mv;		
	}

}
