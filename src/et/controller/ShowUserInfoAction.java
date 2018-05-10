package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.MeetResPartDTO;
import et.model.dto.MemberDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;


public class ShowUserInfoAction implements Action {

	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
			
			EtService service = new EtServiceImpl();
			HttpSession session = request.getSession();
			String loginId = (String) session.getAttribute("loginId");
		
			System.out.println("loginId : " + loginId);
			
			try {
				
				MemberDTO memberDTO = service.selectMember(loginId);
				request.setAttribute("memberDTO", memberDTO);
				//System.out.println("action¿¡¼­ memberName : " + memberDTO.getMemberName());
				request.setAttribute("memberName", memberDTO.getMemberName());
				request.setAttribute("memberBirth", memberDTO.getMemberBirth());
				request.setAttribute("memberGender", memberDTO.getMemberGender());
				request.setAttribute("memberPhone", memberDTO.getMemberPhone());
				request.setAttribute("memberEmail", memberDTO.getMemberEmail());
				request.setAttribute("memberQuestion", memberDTO.getMemberQuestion());
				request.setAttribute("memberAnswer", memberDTO.getMemberAnswer());
				
			
			}catch(SQLException e) {
				e.printStackTrace();		
				request.setAttribute("errorMsg", e.getMessage());
			}
			
			
			mv.setPath("viewMyPage/showUserInfo.jsp");
			
			return mv;
		}
		
	}


