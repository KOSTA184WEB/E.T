package et.model.dao;

import java.sql.SQLException;
import java.util.List;

import et.model.dto.DepositDTO;
import et.model.dto.MeetResPartDTO;

public interface MyPageDAO {

	/**
	 * id�� �ش��ϴ� ������(��û��) ���� �������� 
	 */
	List<MeetResPartDTO> selectUpcomingMeeting(String memberId) throws SQLException;
	
	/**
	 * id�� �ش��ϴ� ������(����) ���� ��������
	 */
	List<MeetResPartDTO> selectPastMeeting(String memberId) throws SQLException;
	
	/**
	 * ���� ��û ����ϱ�
	 */
	int cancelMeeting(String memberId, String participantId) throws SQLException;
	
	/**
	 * ������ ����Ʈ ��������
	 */
	List<DepositDTO> selectDepositList(String memberId) throws SQLException;
	
	/**
	 * ������ ����
	 */
	int addDeposit(DepositDTO depositDTO) throws SQLException;
	
	/**
	 * ������ ����
	 */
	int cutDeposit(DepositDTO depositDTO) throws SQLException;
	
}
