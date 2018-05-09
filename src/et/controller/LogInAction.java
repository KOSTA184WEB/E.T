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

public class LogInAction implements Action {
//
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		
		// post ��� �ѱ� ���ڵ� ����
		request.setCharacterEncoding("UTF-8");
						
		// ���� ���� �������� ��� �� ���ڵ� ����
		response.setContentType("text/html;charset=UTF-8");  // alert��� �� �ѱ� �ʿ�
					
		// ���۵� ������ �ޱ�
		String inputId = request.getParameter("memberId");
		String inputPw = request.getParameter("memberPw");
				
		System.out.println(inputId);
		
		EtService service = new EtServiceImpl();
		
		try {
			MemberDTO memberDTO = service.logIn(inputId, inputPw);
			String dbId = memberDTO.getMemberId();
			String dbPw = memberDTO.getMemberPw();
			
			// �Ѿ�� id�� pwd�� ��ġ�ϸ� LoginOk.jsp�� �̵�
			if(dbId.equals(inputId) && dbPw.equals(inputPw)) {
							
				// loginOk.jsp �� �̵��ϱ� ���� ���ǿ����� �̸��� ���ӽð��� ����
				HttpSession session = request.getSession();
				session.setAttribute("loginId", inputId);
				session.setAttribute("loginPw", inputPw);
				session.setAttribute("loginTime",new Date().toLocaleString());
				
				request.setAttribute("memberDTO", memberDTO);
				
				//mv.setRedirect(true);
				mv.setPath("index.html");
			}

/*			}else { // �ƴϸ� �޽��� ���� �ڷ� �̵��Ѵ�.
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('������ �ٽ� Ȯ�����ּ���.');");
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
