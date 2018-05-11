package et.model.dto;

public class NoticeDTO {
	private String noticeId; //admin_board_id
	private String adminId; //admin_id
	private String noticeTitle; //제목
	private String noticeContents; //내용
	private String noticeWriteday; //작성일
	private int noticeReadnum; //조회수
	private String fileName; //파일이름
	private int fileSize; //파일크기
	private String isPublic; //공개여부
	
	public NoticeDTO() {}

	public NoticeDTO(String noticeId,String adminId, String noticeTitle, String noticeContents, String isPublic) {
		super();
		this.noticeId = noticeId;
		this.adminId = adminId;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.isPublic = isPublic;
	}
	
	public NoticeDTO(String noticeId, String adminId, String noticeTitle, String noticeContents, String noticeWriteday,
			int noticeReadnum, String fileName, int fileSize, String isPublic) {
		this(noticeId, adminId, noticeTitle, noticeContents, isPublic);
		this.noticeWriteday = noticeWriteday;
		this.noticeReadnum = noticeReadnum;
		this.fileName = fileName;
		this.fileSize = fileSize;
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

	public String getfileName() {
		return fileName;
	}

	public void setfileName(String fileName) {
		this.fileName = fileName;
	}

	public int getfileSize() {
		return fileSize;
	}

	public void setfileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
	
}
