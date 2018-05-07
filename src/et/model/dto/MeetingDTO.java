package et.model.dto;

public class MeetingDTO {
	String meetingId; //���� primary key
	String memberId; //������ id
	String resId; //������� id
	String applyNum; //���� �����ο�
	String menu; //���ӿ��� ���� ����
	String maxNum; //��û �ִ� �ο�
	String meetingDate; //���� ��¥
	String deadline; //���� ��û �����ð�
	String meetingDes; //���� ����
	String meetingTitle; //���� ����
	//String meeting_url;
	String genderOption; //���� ���� ���� �� �� ����
	public MeetingDTO() {}
	public MeetingDTO(String meetingId, String memberId, String resId, String applyNum, String menu, String maxNum, String meetingDate, String deadline,
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
	public String getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(String maxNum) {
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
