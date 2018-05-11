package et.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import et.model.dto.NoticeDTO;
import et.model.service.EtService;
import et.model.service.EtServiceImpl;

public class UpdateNoticeAction implements Action {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String adminId = (String)session.getAttribute("loginId"); // ������ ���̵� : etadmin
		String noticeId = request.getParameter("noticeId");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContents = request.getParameter("noticeContents");
		String isPublic = request.getParameter("isPublic"); // �������� ����Ʈ�ڽ� ���ð�
		
		NoticeDTO noticeDTO = new NoticeDTO(noticeId, adminId, noticeTitle, noticeContents, isPublic);
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		try {
			
			//��ȿ�� üũ
			if(adminId==null || noticeId==null ||noticeTitle==null ||noticeContents==null ||isPublic==null) {
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�");
			}
			int re=etService.updateNotice(noticeDTO);
			if(re>0) {
				mv.setPath("ET?command=detailNotice&flag=1&noticeId="+noticeId);
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());;
			mv.setPath("viewError/error.jsp");
		}
		
		return mv;
	}

}
