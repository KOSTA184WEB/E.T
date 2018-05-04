package et.model.dto;

public class ReviewDTO {
	private String reviewId; //�ı� id
	private String partId; //���� id
	private String memberId; //ȸ�� id
	private String resId; //�Ĵ� id                               
	private String reviewTitle; //����
	private String reviewContents; //����
	private int reviewReadnum; //��ȸ��
	private String fileName; //÷������ �̸�
	private int fileSize; //÷������ ũ��
	private String reviewPw; //�Խù� ��й�ȣ
	
	public void ReviewDTO() {}

	public ReviewDTO(String reviewId, String partId, String memberId, String resId, String reviewTitle,
			String reviewContents, int reviewReadnum, String fileName, int fileSize, String reviewPw) {
		super();
		this.reviewId = reviewId;
		this.partId = partId;
		this.memberId = memberId;
		this.resId = resId;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewReadnum = reviewReadnum;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.reviewPw = reviewPw;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
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
