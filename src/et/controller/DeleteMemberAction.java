package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class DeleteMemberAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		mv.setPath("index.html");
		mv.setRedirect(true);

		EtService etService = new EtServiceImpl();

		String memberId = request.getParameter("loginId");

		try {

			int re = etService.deleteMember(memberId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;
	}

}
