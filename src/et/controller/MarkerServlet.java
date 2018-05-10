package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dto.RestaurantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;
import net.sf.json.JSONArray;


@WebServlet("/markerServlet")
public class MarkerServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String resName = request.getParameter("resName");
		
		EtService etService = new EtServiceImpl();
		List<RestaurantDTO> list = new ArrayList<>();
		
		try {
			
			RestaurantDTO dto = etService.selectAllByResName(resName);
			
			if(dto != null) {
				request.setAttribute("dto", dto);
				list.add(dto);
				JSONArray jsonArr = JSONArray.fromObject(list);
				PrintWriter out = response.getWriter();
				out.println(jsonArr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
