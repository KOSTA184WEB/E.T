package et.model.dto;

public class ParticipantDTO {
	
	private String participantId;
	private String memberId;
	private String meetingId;
	private String participantCancel;
	private String participantDate;
	private int applyNum;
	
	public ParticipantDTO() {}
	public ParticipantDTO(String participantId, String memberId, String meetingId, String participantCancel,int applyNum) {
		super();
		this.participantId = participantId;
		this.memberId = memberId;
		this.meetingId = meetingId;
		this.participantCancel = participantCancel;
		this.applyNum = applyNum;
	}
	public ParticipantDTO(String participantId, String memberId, String meetingId, String participantCancel,
			String participantDate,int applyNum) {
		this(participantId,memberId,meetingId,participantCancel,applyNum);
		this.participantDate = participantDate;
	}
	public ParticipantDTO(String participantId, String memberId, String meetingId, String participantCancel) {
		super();
		this.participantId= participantId;
		this.memberId = memberId;
		this.meetingId= meetingId;
		this.participantCancel = participantCancel;	
	}
	public String getParticipantId() {
		return participantId;
	}
	public void setParticipantId(String participantId) {
		this.participantId = participantId;
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
	public String getParticipantCancel() {
		return participantCancel;
	}
	public void setParticipantCancel(String participantCancel) {
		this.participantCancel = participantCancel;
	}
	public String getParticipantDate() {
		return participantDate;
	}
	public void setParticipantDate(String participantDate) {
		this.participantDate = participantDate;
	}
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	
	

}
