package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.MemberDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;
import et.model.service.MyPageService;

public class LogInAction implements Action {
//
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		
		// post 방식 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
						
		// 현재 문서 브라우저에 출력 시 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");  // alert띄울 때 한글 필요
					
		// 전송된 데이터 받기
		String inputId = request.getParameter("memberId");
		String inputPw = request.getParameter("memberPw");
				
		System.out.println(inputId);
		
		EtService service = new EtServiceImpl();
		
		try {
			MemberDTO memberDTO = service.logIn(inputId, inputPw);
			String dbId = memberDTO.getMemberId();
			String dbPw = memberDTO.getMemberPw();
			
			// 넘어온 id와 pwd가 일치하면 LoginOk.jsp로 이동
			if(dbId.equals(inputId) && dbPw.equals(inputPw)) {
							
				// loginOk.jsp 로 이동하기 전에 세션영역에 이름과 접속시간을 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginId", inputId);
				session.setAttribute("loginTime",new Date().toLocaleString());
				
				request.setAttribute("memberDTO", memberDTO);
				
				//mv.setRedirect(true);
				mv.setPath("viewLogin/loginOk.jsp");
			}

/*			}else { // 아니면 메시지 띄우고 뒤로 이동한다.
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('정보를 다시 확인해주세요.');");
				out.println("location.href='loginForm.jsp';");
				out.println("history.back();");
				out.println("</script>");
			}		*/
		
		}catch(SQLException e) {
			e.printStackTrace();		
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		return mv;

	}
}
