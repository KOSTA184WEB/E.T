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
			throw new SQLException("������ ������ �����ϴ�.");
		}
		
		return userMeetingList;
	}
	
	public List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException{
		
		List<MeetResPartDTO> pastMeetingList = myPageDAO.selectPastMeeting(memberId);
		if(pastMeetingList==null) {
			throw new SQLException("������ ������ �����ϴ�.");
		}
		
		return pastMeetingList;
	}
	
	public int cancelMeeting(String memberId, String participantId) throws SQLException{ // �Ķ���Ϳ� � ���� �����ϴ��� ���� �ʿ�!!!
		
		int result = myPageDAO.cancelMeeting(memberId, participantId);
		
		if(result==0) {
			throw new SQLException("���sql ����");
		}
		
		return result;
	} 
	
	public List<DepositDTO> selectDepositList(String memberId) throws SQLException{
		
		List<DepositDTO> depositList = myPageDAO.selectDepositList(memberId);
		
		if(depositList==null) {
			throw new SQLException("������ ��� ������ �����ϴ�.");
		}
		
		return depositList;
	}
	
	*/
	
	/**
	 * �α���
	 */
	
	/*public MemberDTO logIn(String memberId, String memberPw) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		int result = MemberDAO.loginCheck(memberId, memberPw); // �α��� Ȯ��
		
		if(result==1){ // ���̵� ������ ��
			memberDTO = MemberDAO.selectMember(memberId); // ȸ�� ���� ���
		}else{
			throw new SQLException("�α��� �� �� �����ϴ�.");
		}
		
		return memberDTO;
	}
	
	*//**
	 * ȸ�� ������ ��������
	 *//*
	public MemberDTO selectMemberInfo(String memberId) throws SQLException {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO = MemberDAO.selectMember(memberId); // ȸ�� ���� ���
		
		if(memberDTO==null){
			throw new SQLException("ȸ�� ���� �ҷ��� �� �����ϴ�.");
		}
		
		return memberDTO;
	}

	*//**
	 * ȸ�� ���� ����
	 *//*
	public int updateMemberInfo(MemberDTO memberDTO) throws SQLException{
		
		int result = MemberDAO.updateMember(memberDTO);
		if(result==0) {
			throw new SQLException("ȸ�� ���� ���� ����");
		}
		
		return result;
	}
	*/
}
