package et.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import et.controller.Action;

@WebListener
public class ActionMappingListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e)  { 
		//�̸� ��ü �����Ͽ� Map�� ���� => application ���� (���� �ʱ�ȭ �۾�)
		Map<String, Action> map = new HashMap<>();
		ServletContext application = e.getServletContext();
		//��ü���� ������ ~.properties ���Ͽ� �ֱ� ������ �� ������ �̸� �о�´�.(ResourceBundle ��ü �̿���)
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
