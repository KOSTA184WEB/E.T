package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class SelectReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("버튼 도착");
	     EtService etService= new EtServiceImpl();
		 //값 받아오기
	     String keyField = request.getParameter("keyField");
	     String keyWord = request.getParameter("keyWord");
	     System.out.println(keyField); 
	     System.out.println(keyWord); 
	     ModelAndView mv = new ModelAndView();
		
	     List<ReviewDTO> list;
		try {
			list = etService.searchBykeyWord(keyField, keyWord);
			
		     request.setAttribute("list", list);
		     mv.setPath("viewReview/mainReviewView.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
	      
		return mv;
	}

}
