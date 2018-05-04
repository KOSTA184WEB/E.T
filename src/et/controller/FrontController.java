package et.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ET")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Action> map ;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//application������ ����� Map�� ������ ���������� �����Ѵ�.
		map = (Map<String, Action>)config.getServletContext().getAttribute("map");
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter�Ѿ���� command �ޱ� = key
		String key = request.getParameter("command");
		if(key==null)key="list";
		
		//map���� key�� �ش��ش� Ŭ������ ������ �޼ҵ带 ȣ���ϰ� ���ϰ��� �޴´�.
		
		//���ϰ�(ModelAndView)�� ���� �̵���İ� �̵���θ� ���Ѵ�.
		System.out.println(key);
		Action action = map.get(key);
		ModelAndView mv = action.execute(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getPath());
		}else {
			request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
		
		
	}

}






