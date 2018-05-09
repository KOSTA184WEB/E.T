package et.model.dto;

public class MeetingDTO {
	String meetingId; //모임 primary key
	String memberId; //주최자 id
	String resId; //모임장소 id
	int applyNum; //현재 참가인원
	String menu; //모임에서 먹을 음식
	int maxNum; //신청 최대 인원
	String meetingDate; //모임 날짜
	String deadline; //모임 신청 마감시간
	String meetingDes; //모임 설명
	String meetingTitle; //모임 제목
	//String meeting_url;
	String genderOption; //모임 성별 제한 남 녀 무관
	public MeetingDTO() {}
	public MeetingDTO(String meetingId, String memberId, String resId, int applyNum, String menu, int maxNum, String meetingDate, String deadline,
			String meetingDes, String meetingTitle, String genderOption) {
		super();
		this.meetingId = meetingId;
		this.memberId = memberId;
		this.resId = resId;
		this.applyNum = applyNum;
		this.menu = menu;
		this.maxNum = maxNum;
		this.meetingDate = meetingDate;
		this.deadline = deadline;
		this.meetingDes = meetingDes;
		this.meetingTitle = meetingTitle;
		this.genderOption = genderOption;
	}
	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getMeetingDes() {
		return meetingDes;
	}
	public void setMeetingDes(String meetingDes) {
		this.meetingDes = meetingDes;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getGenderOption() {
		return genderOption;
	}
	public void setGenderOption(String genderOption) {
		this.genderOption = genderOption;
	}
	
	
}
