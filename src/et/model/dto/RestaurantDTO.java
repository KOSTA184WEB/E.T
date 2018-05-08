package et.model.dto;

public class RestaurantDTO {
	String resId; //�Ĵ�ID
	String resName; //�Ĵ��
	String resKind; //�Ĵ� ���� ����
	String resAddress; //�Ĵ� �ּ�
	String resPhone; //�Ĵ� ����ó
	int resRate; //����
	double lat; //����
	double lng; //�浵
	int meetingCount; //���� ��Ⱦ ȸ��
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
	public void setLat(int lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(int lng) {
		this.lng = lng;
	}
	public int getMeetingCount() {
		return meetingCount;
	}
	public void setMeetingCount(int meetingCount) {
		this.meetingCount = meetingCount;
	}
	
	
}
