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
		
		String saveDir = request.getServletContext().getRealPath("/save");//저장할곳
		int maxSize=1024*1024*100; //100메가
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		ModelAndView mv = new ModelAndView();
		
		if(m.getFilesystemName("file")!=null) { //file: write의 파일첨부부분 name //파일 첨부가 되었다면
			
		}
		
		return null;
	}

}
