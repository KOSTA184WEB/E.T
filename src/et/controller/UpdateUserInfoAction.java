package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dao.MyPageDAOImpl;
import et.model.dto.MemberDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;


public class UpdateUserInfoAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		String memberPw = request.getParameter("Password");
		String memberGender = request.getParameter("gender");
		String memberPhone = request.getParameter("phone");
		String memberEmail = request.getParameter("email");
		String memberAnswer = request.getParameter("answer");
		
		MemberDTO memberDTO = new MemberDTO(loginId, memberPw, memberGender, memberPhone, memberEmail, memberAnswer);
		
		try {
			EtService service = new EtServiceImpl();
			service.updateMember(memberDTO);
			mv.setPath("ET?command=showUserInfo");
			
		}catch(SQLException e) {
			e.printStackTrace();		
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		return mv;
	}
}
