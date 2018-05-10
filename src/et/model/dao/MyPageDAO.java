package et.model.dao;

import java.sql.SQLException;
import java.util.List;

import et.model.dto.DepositDTO;
import et.model.dto.MeetResPartDTO;

public interface MyPageDAO {

	/**
	 * id에 해당하는 참여할(신청한) 모임 가져오기 
	 */
	List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException;
	
	/**
	 * id에 해당하는 참여한(지난) 모임 가져오기
	 */
	List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException;
	
	/**
	 * 모임 신청 취소하기
	 */
	int cancelMeeting(String memberId, String participantId) throws SQLException;
	
	/**
	 * 디파짓 리스트 가져오기
	 */
	List<DepositDTO> selectDepositList(String memberId) throws SQLException;
	
	/**
	 * 디파짓 충전
	 */
	int addDeposit(DepositDTO depositDTO) throws SQLException;
	
	/**
	 * 디파짓 차감
	 */
	int cutDeposit(DepositDTO depositDTO) throws SQLException;
	
}
