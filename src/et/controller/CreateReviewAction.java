package et.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import et.model.dto.ReviewDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class CreateReviewAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String saveDir = request.getServletContext().getRealPath("/save");//저장할곳
		int maxSize=1024*1024*100; //100메가
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		/*String meetListId = m.getParameter("meetListId");
		//System.out.println("meetListId: "+meetListId);
		String meetListTitle = m.getParameter("meetListTitle");
		System.out.println("meetListTitle : " +meetListTitle);
		//String  meetListId = m.getParameterValues("meetListId");
		//System.out.println("meetListId : "+meetListId[0]);
		//String [] meetListTitle = m.getParameterValues("meetListTitle");
		//System.out.println("meetListTitle : "+meetListTitle[0]);
		
		String meetingId=null;
		for(int i=0; i<meetListTitle.length; i++) {
			for(int j=0; j<meetListId.length; j++) {
				System.out.println("meetListId[i] : "+meetListId[i]);
				meetingId=meetListId[i];
			}
		}
		System.out.println("Action meetingId:"+meetingId);*/
		
		EtService etService = new EtServiceImpl();
		
		String meetingId = m.getParameter("meetListId");
 		String memberId=m.getParameter("memberId");
 		String resId=null;
		
 		try {
			resId = etService.selectRestaurantId(meetingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String resRate= m.getParameter("resRate");
		String reviewId = m.getParameter("reviewId");
		String reviewTitle = m.getParameter("reviewTitle");
		String reviewContents = m.getParameter("reviewContents");
		String reviewPw = m.getParameter("reviewPw");
		//System.out.println("reviewPw : "+reviewPw);
			
		ModelAndView mv = new ModelAndView();
			
		ReviewDTO reviewDto = new ReviewDTO(reviewId, memberId, meetingId, resId, reviewTitle, reviewContents, reviewPw);
			
		if(m.getFilesystemName("file")!=null) { //file: write의 파일첨부부분 name //파일 첨부가 되었다면
			reviewDto.setFileName(m.getFilesystemName("file"));
			reviewDto.setFileSize((int)m.getFile("file").length());
		}
			
		try{	
			int re = etService.insertReview(reviewDto);
			int reRate=etService.insertResturantRate(Integer.parseInt(resRate), resId);
				
			if(re>0 || reRate>0) {
					
				mv.setPath("ET?command=listReview");
				mv.setRedirect(true); //redirect방식으로 이동
			}
		}catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		} 
		return mv;
	}

}
