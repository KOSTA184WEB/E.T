package et.model.service;

import java.sql.SQLException;
import java.util.List;

import et.model.dao.MemberDAO;
/*import et.model.dao.MyPageDAO;
import et.model.dao.MyPageDAOImpl;
import et.model.dto.DepositDTO;
import et.model.dto.MeetResPartDTO;*/
import et.model.dto.MemberDTO;

public class MyPageService {

	/*private MyPageDAO myPageDAO = new MyPageDAOImpl();
	
	public List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException{
				
		List<MeetResPartDTO> userMeetingList = myPageDAO.selectUpcomingMeeting(memberId);
		if(userMeetingList==null) {
			throw new SQLException("예약한 모임이 없습니다.");
		}
		
		return userMeetingList;
	}
	
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException{
		
		List<MeetResPartDTO> pastMeetingList = myPageDAO.selectPastMeeting(memberId);
		if(pastMeetingList==null) {
			throw new SQLException("예약한 모임이 없습니다.");
		}
		
		return pastMeetingList;
	}
	
	public int cancelMeeting(String memberId, String participantId) throws SQLException{ // 파라미터에 어떤 정보 들어가야하는지 생각 필요!!!
		
		int result = myPageDAO.cancelMeeting(memberId, participantId);
		
		if(result==0) {
			throw new SQLException("취소sql 실패");
		}
		
		return result;
	} 
	
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException{
		
		List<DepositDTO> depositList = myPageDAO.selectDepositList(memberId);
		
		if(depositList==null) {
			throw new SQLException("디파짓 사용 내역이 없습니다.");
		}
		
		return depositList;
	}
	
	*/
	
	/**
	 * 로그인
	 */
	
	/*public MemberDTO logIn(String memberId, String memberPw) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		int result = MemberDAO.loginCheck(memberId, memberPw); // 로그인 확인
		
		if(result==1){ // 아이디 존재할 때
			memberDTO = MemberDAO.selectMember(memberId); // 회원 정보 담기
		}else{
			throw new SQLException("로그인 할 수 없습니다.");
		}
		
		return memberDTO;
	}
	
	*//**
	 * 회원 정보만 가져오기
	 *//*
	public MemberDTO selectMemberInfo(String memberId) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO = MemberDAO.selectMember(memberId); // 회원 정보 담기
		
		if(memberDTO==null){
			throw new SQLException("회원 정보 불러올 수 없습니다.");
		}
		
		return memberDTO;
	}

	*//**
	 * 회원 정보 수정
	 *//*
	public int updateMemberInfo(MemberDTO memberDTO) throws SQLException{
		
		int result = MemberDAO.updateMember(memberDTO);
		if(result==0) {
			throw new SQLException("회원 정보 수정 실패");
		}
		
		return result;
	}
	*/
}
