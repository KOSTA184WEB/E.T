package et.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.controller.Action;

@WebListener
public class ActionMappingListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e)  { 
		//미리 객체 생성하여 Map에 저장 => application 저장 (사전 초기화 작업)
		Map<String, Action> map = new HashMap<>();
		ServletContext application = e.getServletContext();
		//객체들의 정보는 ~.properties 파일에 있기 때문에 이 파일을 미리 읽어온다.(ResourceBundle 객체 이용방법)
		String fileName = application.getInitParameter("fileName");
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Iterator<String> it = rb.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String className = rb.getString(key);
			
			try {
				Action action = (Action)Class.forName(className).newInstance();
				map.put(key, action);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		application.setAttribute("map", map);
	}
	
    public void contextDestroyed(ServletContextEvent e)  { 

    }
    
}
