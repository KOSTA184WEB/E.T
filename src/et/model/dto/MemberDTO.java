package et.model.dto;
//
public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberBirth;
	private int memberAge;
	private String memberGender;
	private String memberPhone;
	private String memberEmail;
	private String memberQuestion;
	private String memberAnswer;
	private int reportCount;
	
	public MemberDTO(){}
	
	// ¼öÁ¤¿ë
	public MemberDTO(String memberId, String memberPw, String memberPhone, String memberEmail, String memberAnswer) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAnswer = memberAnswer;
	}
	
	public MemberDTO(String memberId, String memberPw, String memberName, int memberBirth, int memberAge, String memberGender,
			String memberPhone, String memberEmail, String memberQuestion, String memberAnswer) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberAge = memberAge;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberQuestion = memberQuestion;
		this.memberAnswer = memberAnswer;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public int getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(int memberBirth) {
		this.memberBirth = memberBirth;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberQuestion() {
		return memberQuestion;
	}

	public void setMemberQuestion(String memberQuestion) {
		this.memberQuestion = memberQuestion;
	}

	public String getMemberAnswer() {
		return memberAnswer;
	}

	public void setMemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}
	
	
	
}
