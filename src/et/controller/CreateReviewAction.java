package et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CreateReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String saveDir = request.getServletContext().getRealPath("/save");//�����Ұ�
		int maxSize=1024*1024*100; //100�ް�
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		ModelAndView mv = new ModelAndView();
		
		if(m.getFilesystemName("file")!=null) { //file: write�� ����÷�κκ� name //���� ÷�ΰ� �Ǿ��ٸ�
			
		}
		
		return null;
	}

}
