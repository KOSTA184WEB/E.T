package et.model.dto;

public class MeetingDTO {
	
	private String meetingId;
	private String memberId;
	private String resId;
	private int applyNum;
	private String menu;
	private int maxNum;
	private String meetingDate;
	private String deadLine;
	private String meetingDescription;
	private String meetingTitle;
	private String meetingUrl;
	private String genderOption;
	
	public MeetingDTO() {}
	public MeetingDTO(String meetingId, String memberId, String resId, int applyNum, String menu, int maxNum,
			String meetingDate, String deadLine, String meetingDescription, String meetingTitle, String meetingUrl,
			String genderOption) {
		super();
		this.meetingId = meetingId;
		this.memberId = memberId;
		this.resId = resId;
		this.applyNum = applyNum;
		this.menu = menu;
		this.maxNum = maxNum;
		this.meetingDate = meetingDate;
		this.deadLine = deadLine;
		this.meetingDescription = meetingDescription;
		this.meetingTitle = meetingTitle;
		this.meetingUrl = meetingUrl;
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
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String getMeetingDescription() {
		return meetingDescription;
	}
	public void setMeetingDescription(String meetingDescription) {
		this.meetingDescription = meetingDescription;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public String getMeetingUrl() {
		return meetingUrl;
	}
	public void setMeetingUrl(String meetingUrl) {
		this.meetingUrl = meetingUrl;
	}
	public String getGenderOption() {
		return genderOption;
	}
	public void setGenderOption(String genderOption) {
		this.genderOption = genderOption;
	}
	
	
	
	
	

}
