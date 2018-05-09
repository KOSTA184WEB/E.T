package et.model.dto;

public class ReviewDTO {
	private String reviewId; //�ı� id
	private String memberId; //ȸ�� id
	private String meetingId; //���� id
	private String resId; //�Ĵ� id                               
	private String reviewTitle; //����
	private String reviewContents; //����
	private String reviewWriteday; //�ۼ��� 
	private int reviewReadnum; //��ȸ��
	private String fileName; //÷������ �̸�
	private int fileSize; //÷������ ũ��
	private String reviewPw; //�Խù� ��й�ȣ
	
	public ReviewDTO() {}
	public ReviewDTO(String memberId) {
		this.memberId=memberId;
	}
	public ReviewDTO(String reviewId, String reviewPw) {
		this.reviewId=reviewId;
		this.reviewPw = reviewPw;
	}
	
	public ReviewDTO(String reviewId, String memberId, String meetingId, String resId,
			String reviewTitle, String reviewContents, String reviewPw) {
		this(reviewId,reviewPw);
		this.meetingId=meetingId;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.memberId=memberId;
		this.resId = resId;
	}
	public ReviewDTO(String reviewId, String memberId, String meetingId, String resId,
			String reviewTitle, String reviewContents, String reviewWriteday, int reviewReadnum, String fileName,
			int fileSize, String reviewPw) {
		this(reviewId, memberId, meetingId, resId, reviewTitle, reviewContents, reviewPw);
		this.reviewWriteday = reviewWriteday;
		this.reviewReadnum = reviewReadnum;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public String getReviewWriteday() {
		return reviewWriteday;
	}

	public void setReviewWriteday(String reviewWriteday) {
		this.reviewWriteday = reviewWriteday;
	}

	public int getReviewReadnum() {
		return reviewReadnum;
	}

	public void setReviewReadnum(int reviewReadnum) {
		this.reviewReadnum = reviewReadnum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getReviewPw() {
		return reviewPw;
	}

	public void setReviewPw(String reviewPw) {
		this.reviewPw = reviewPw;
	}

	
}
