package et.model.service;

import java.util.List;

import et.model.dto.MeetingDTO;
import et.model.dto.MeetingReviewDTO;

public interface EtService {
	
	/**
	 * Meeting 생성하기
	 * @param meetingDto
	 * @return
	 */
	public int createMeeting(MeetingDTO meetingDto);

	/**
	 * 전체 Meeting List 가져오기
	 * @return
	 */
	public List<MeetingDTO> selectMeetingList();
	
	/**
	 * Meeting 이름으로 검색
	 * @param name
	 * @return
	 */
	public MeetingDTO selectMeetingByName(String name);

	/**
	 * Meeting 주최자인지 확인
	 * @param meetingNum
	 * @param memberId
	 * @return
	 */
	public boolean isMeetingOpener(String meetingNum,String memberId);
		
	/**
	 * Meeting 정보 update
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
	 * Meeting에 참가하기
	 * @param memberId
	 * @param meetingId
	 * @return
	 */
	public int participateMeeting(String memberId,String meetingId);
	
	/**
	 * 사용자가 해당 모임의 참가자인지 판별하기
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
