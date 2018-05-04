package et.model.dto;

public class ReviewDTO {
	private String reviewId; //후기 id
	private String partId; //참여 id
	private String memberId; //회원 id
	private String resId; //식당 id                               
	private String reviewTitle; //제목
	private String reviewContents; //내용
	private int reviewReadnum; //조회수
	private String fileName; //첨부파일 이름
	private int fileSize; //첨부파일 크기
	private String reviewPw; //게시물 비밀번호
	
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
