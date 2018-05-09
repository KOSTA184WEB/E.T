package et.model.dto;

public class RestaurantDTO {
	String resId; //식당ID
	String resName; //식당명
	String resKind; //식당 음식 종류
	String resAddress; //식당 주소
	String resPhone; //식당 연락처
	int resRate; //평점
	double lat; //위도
	double lng; //경도
	int meetingCount; //모임 진횡 회수
	public RestaurantDTO() {}
	public RestaurantDTO(String resId, String resName, String resKind, String resAddress, String resPhone, int resRate, double lat, double lng, int meetingCount) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resKind = resKind;
		this.resAddress = resAddress;
		this.resPhone = resPhone;
		this.resRate = resRate;
		this.lat = lat;
		this.lng = lng;
		this.meetingCount = meetingCount;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
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
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public int getResRate() {
		return resRate;
	}
	public void setResRate(int resRate) {
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
