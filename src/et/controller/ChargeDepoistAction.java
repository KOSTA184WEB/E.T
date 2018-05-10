package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.DepositDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class ChargeDepoistAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		EtService service = new EtServiceImpl();
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		int chargeD = Integer.parseInt(request.getParameter("chargeD")); // 입력된 충전할 디파짓 값
		System.out.println(chargeD);
		String depositDescription = "충전";
		
		DepositDTO depositDTO = new DepositDTO(loginId,depositDescription,chargeD);
		
		try {
			service.addDepoist(depositDTO);

			mv.setPath("ET?command=depositList");
			
		}catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("viewError/error.jsp");
		}
		
		return mv;
		
	}	
}
