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
		
		String adminId = (String)session.getAttribute("loginId"); // 관리자 아이디 : etadmin
		String noticeId = request.getParameter("noticeId");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContents = request.getParameter("noticeContents");
		String isPublic = request.getParameter("isPublic"); // 공개여부 셀렉트박스 선택값
		
		NoticeDTO noticeDTO = new NoticeDTO(noticeId, adminId, noticeTitle, noticeContents, isPublic);
		ModelAndView mv = new ModelAndView();
		EtService etService = new EtServiceImpl();
		try {
			
			//유효성 체크
			if(adminId==null || noticeId==null ||noticeTitle==null ||noticeContents==null ||isPublic==null) {
				throw new SQLException("입력값이 충분하지 않습니다");
			}
			int re=etService.updateNotice(noticeDTO);
			if(re>0) {
				mv.setPath("ET?command=detailNotice&flag=1&noticeId="+noticeId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}

}
