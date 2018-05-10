package et.model.dto;

public class NoticeDTO {
	private String noticeId; //admin_board_id
	private String adminId; //admin_id
	private String noticeTitle; //����
	private String noticeContents; //����
	private String noticeWriteday; //�ۼ���
	private int noticeReadnum; //��ȸ��
	private String fName; //�����̸�
	private int fSize; //����ũ��
	private String isPublic; //��������
	
	public NoticeDTO() {}

	public NoticeDTO(String noticeId, String adminId, String noticeTitle, String noticeContents, String noticeWriteday,
			int noticeReadnum, String fName, int fSize, String isPublic) {
		super();
		this.noticeId = noticeId;
		this.adminId = adminId;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.noticeWriteday = noticeWriteday;
		this.noticeReadnum = noticeReadnum;
		this.fName = fName;
		this.fSize = fSize;
		this.isPublic = isPublic;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public String getNoticeWriteday() {
		return noticeWriteday;
	}

	public void setNoticeWriteday(String noticeWriteday) {
		this.noticeWriteday = noticeWriteday;
	}

	public int getNoticeReadnum() {
		return noticeReadnum;
	}

	public void setNoticeReadnum(int noticeReadnum) {
		this.noticeReadnum = noticeReadnum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getfSize() {
		return fSize;
	}

	public void setfSize(int fSize) {
		this.fSize = fSize;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
	
}
