package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import et.model.dto.NoticeDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class CreateNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Create ����!!!");
		
		String saveDir = request.getServletContext().getRealPath("/save");//�����Ұ�
		int maxSize=1024*1024*100; //100�ް�
		String encoding="UTF-8";
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId"); // ������ ���̵� : etadmin
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		EtService etService = new EtServiceImpl();
		
		
		String noticeId=m.getParameter("noticeId");
		String noticeTitle = m.getParameter("noticeTitle");
		String noticeContents = m.getParameter("noticeContents");
		String isPublic = m.getParameter("isPublic"); // �������� ����Ʈ�ڽ� ���ð�
		
		System.out.println(noticeId);
		System.out.println(noticeTitle);
		System.out.println(noticeContents);
		System.out.println(isPublic);
		
		ModelAndView mv = new ModelAndView();
			
		NoticeDTO noticeDTO = new NoticeDTO(noticeId,loginId,noticeTitle,noticeContents,isPublic);
		
		if(m.getFilesystemName("file")!=null) { //file: write�� ����÷�κκ� name //���� ÷�ΰ� �Ǿ��ٸ�
			noticeDTO.setfileName(m.getFilesystemName("file"));
			noticeDTO.setfileSize((int)m.getFile("file").length());
		}
			
		try{	
			int re = etService.insertNotice(noticeDTO);
							
			if(re>0) {
					
				mv.setPath("ET?command=listNotice");
				mv.setRedirect(true); //redirect������� �̵�
			}
		}catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		} 
		return mv;
	}
}
