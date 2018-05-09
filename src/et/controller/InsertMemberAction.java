package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.MemberDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class InsertMemberAction implements Action {

	// 회원을 등록하는 action파일

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		mv.setPath("viewSignUp/signUpIntro.jsp");
		mv.setRedirect(true);
		try {
			request.setCharacterEncoding("UTF-8");// post방식 한글처리
			PrintWriter out = response.getWriter();

			EtService service = new EtServiceImpl();

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String age = request.getParameter("birth");
			String birth = request.getParameter("birth");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String quest = request.getParameter("ask");
			String anser = request.getParameter("answ");
			
			MemberDTO memberDTO = new MemberDTO(id, pw, name, Integer.parseInt(age), Integer.parseInt(birth), gender, phone, email, quest, anser);

			int result = service.insertMember(memberDTO);
			if (result == 0) {
			} else {
				mv.setPath("index.html");
				mv.setRedirect(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
