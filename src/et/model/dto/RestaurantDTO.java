package et.model.dto;

public class RestaurantDTO {
	
	private String resId;
	private String resName;
	private String resKind;
	private String resAddr;
	private String resPhone;
	private String resRate;
	private long lat;
	private long lng;
	private int meetingCount;
	
	public RestaurantDTO() {}
	public RestaurantDTO(String resId, String resName, String resKind, String resAddr, String resPhone, String resRate,
			long lat, long lng, int meetingCount) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resKind = resKind;
		this.resAddr = resAddr;
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
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}
	public long getLng() {
		return lng;
	}
	public void setLng(long lng) {
		this.lng = lng;
	}
	public int getMeetingCount() {
		return meetingCount;
	}
	public void setMeetingCount(int meetingCount) {
		this.meetingCount = meetingCount;
	}
	
	

}
