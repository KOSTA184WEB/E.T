package et.model.dto;

public class MeetResDTO {
	
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
	
	private String resName;
	private String resKind;
	private String resAddr;
	private String resPhone;
	private String resRate;
	private double lat;
	private double lng;
	private int meetingCount;
	
	public MeetResDTO() {}
	public MeetResDTO(String resAddr,String resName,int applyNum, String genderOptionm, String meetingDate, String meetingDescription,double lat,double lng,String meetingId,int maxNum){
		this.resAddr = resAddr;
		this.resName = resName;
		this.applyNum = applyNum;
		this.genderOption = genderOptionm;
		this.meetingDate = meetingDate;
		this.meetingDescription = meetingDescription; 
		this.lat = lat;
		this.lng = lng;
		this.meetingId = meetingId;
		this.maxNum = maxNum;
		
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
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResKind() {
		return resKind;
	}
	public void setResKind(String resKind) {
		this.resKind = resKind;
	}
	public String getResAddr() {
		return resAddr;
	}
	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public String getResRate() {
		return resRate;
	}
	public void setResRate(String resRate) {
		this.resRate = resRate;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public int getMeetingCount() {
		return meetingCount;
	}
	public void setMeetingCount(int meetingCount) {
		this.meetingCount = meetingCount;
	}
	
	

}
