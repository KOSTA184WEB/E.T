package et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import et.model.dao.HotplaceDAO;
import et.model.dto.RestaurantDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class HotPlaceAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		EtService etService = new EtServiceImpl();
		ModelAndView mv = new ModelAndView();
		
		PrintWriter out = response.getWriter();
		
		String keyWord = request.getParameter("keyWord");
		
		List<RestaurantDTO> restaurantList = null;
		
		try {
			restaurantList = etService.selectByKeyWord(keyWord);
					
			JSONObject obj = new JSONObject();	
			
			try {
				JSONArray jArray = new JSONArray();
				for(int i = 0; i<restaurantList.size(); i++) {
					JSONObject sObject = new JSONObject();
					sObject.put("resName", restaurantList.get(i).getResName());
					sObject.put("lat", restaurantList.get(i).getLat());
					sObject.put("lng", restaurantList.get(i).getLng());
					jArray.add(sObject);
				}
				
				obj.put("item", jArray);
				
				
			}catch(JSONException e) {
				e.printStackTrace();
			}
			
			String objString = obj.toString();
			request.setAttribute("obj", objString);
			mv.setPath("/viewHotplace/hotPlaceListView.jsp");
			//request.getRequestDispatcher("meetView/hotPlaceListView.jsp").forward(request,response);
		
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("/viewError/error.jsp");
		}
				
				
		return mv;
	}

}
