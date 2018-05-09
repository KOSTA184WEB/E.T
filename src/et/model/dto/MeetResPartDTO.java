package et.model.dto;

/**
 * id에 해당하는 신청한 모임 리스트 DTO
 */
public class MeetResPartDTO {

	private String memberId;
	private String meetingId;
	private String participantId;
	private String meetingDate;
	private String meetingTime;
	private String meetingTitle;
	private String participantDate;
	
	public MeetResPartDTO() {}
	
	public MeetResPartDTO(String memberId, String meetingId, String participantId, String meetingDate, String meetingTime, String meetingTitle, String participantDate) {
		super();
		this.memberId = memberId;
		this.meetingId = meetingId;
		this.participantId = participantId;
		this.meetingDate = meetingDate;
		this.meetingTime = meetingTime;
		this.meetingTitle = meetingTitle;
		this.participantDate = participantDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}	
	public String getParticipantId() {
		return participantId;
	}
	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getParticipantDate() {
		return participantDate;
	}
	public void setParticipantDate(String participantDate) {
		this.participantDate = participantDate;
	}
	
	
	
	
}
