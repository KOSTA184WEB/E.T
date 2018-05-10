package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.DepositDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class SelectDepositListAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		EtService service = new EtServiceImpl();
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		try {
			//DepositDTO depositDTO = new DepositDTO();
			List<DepositDTO> depositList = service.selectDepositList(loginId);
			request.setAttribute("depositList", depositList);
			
		}catch(SQLException e) {
			e.printStackTrace();		
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("viewError/error.jsp");
		}
		
		mv.setPath("viewMyPage/depositConfirmView.jsp");
		
		return mv;
	}

}
