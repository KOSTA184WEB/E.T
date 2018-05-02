package et.model.service;

import java.util.List;

import et.model.dto.MeetingDTO;
import et.model.dto.MeetingReviewDTO;

public interface EtService {
	
	/**
	 * Meeting �����ϱ�
	 * @param meetingDto
	 * @return
	 */
	public int createMeeting(MeetingDTO meetingDto);

	/**
	 * ��ü Meeting List ��������
	 * @return
	 */
	public List<MeetingDTO> selectMeetingList();
	
	/**
	 * Meeting �̸����� �˻�
	 * @param name
	 * @return
	 */
	public MeetingDTO selectMeetingByName(String name);

	/**
	 * Meeting ���������� Ȯ��
	 * @param meetingNum
	 * @param memberId
	 * @return
	 */
	public boolean isMeetingOpener(String meetingNum,String memberId);
		
	/**
	 * Meeting ���� update
	 * @param meetingDto
	 * @return
	 */
	public int updateMeeting(MeetingDTO meetingDto);
	
	/**
	 * Meeting delete
	 * @param meetingNum
	 * @return
	 */
	public int deleteMeeting(String meetingNum);
	
	/**
	 * Meeting�� �����ϱ�
	 * @param memberId
	 * @param meetingId
	 * @return
	 */
	public int participateMeeting(String memberId,String meetingId);
	
	/**
	 * ����ڰ� �ش� ������ ���������� �Ǻ��ϱ�
	 * @param memberId
	 * @param meetingId
	 * @return
	 */
	public boolean isParticipant(String memberId,String meetingNum);
	
	public int leaveMeeting(String memberId,String meetingNum);
	
	public List<MeetingDTO> selectHotPlace();
	
	public int updateHotplace();
	
	public int createReview(String memberId,MeetingReviewDTO reviewDto);
	
}
