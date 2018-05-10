package et.model.dto;

public class DepositDTO {

	private String memberId;
	private String depositDescription;
	private int plusDeposit;
	private int minusDeposit;
	private int currentDeposit;
	private String depositUpdateDate;
	
	public DepositDTO() {}	
	public DepositDTO(String memberId, String depositDescription, int plusDeposit, int minusDeposit, int currentDeposit,
			String depositUpdateDate) {
		super();
		this.memberId = memberId;
		this.depositDescription = depositDescription;
		this.plusDeposit = plusDeposit;
		this.minusDeposit = minusDeposit;
		this.currentDeposit = currentDeposit;
		this.depositUpdateDate = depositUpdateDate;
	}

	// ������ ����, ȸ������, ���� �ۼ� (add)
	public DepositDTO(String memberId, String depositDescription, int plusDeposit) {
		super();
		this.memberId = memberId;
		this.depositDescription = depositDescription;
		this.plusDeposit = plusDeposit;
	}
	
	// ������ ����, ȸ������, ���� �ۼ� (add) ����Ʈ
	public DepositDTO(String memberId, String depositDescription, int plusDeposit, int currentDeposit, String depositUpdateDate) {
		super();
		this.memberId = memberId;
		this.depositDescription = depositDescription;
		this.plusDeposit = plusDeposit;
	}

	// ����������û, (cut)
	public DepositDTO(String memberId, String depositDescription, int minusDeposit, String depositUpdateDate, int currentDeposit) {
		super();
		this.memberId = memberId;
		this.depositDescription = depositDescription;
		this.minusDeposit = minusDeposit;
		this.currentDeposit = currentDeposit;
		this.depositUpdateDate = depositUpdateDate;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDepositDescription() {
		return depositDescription;
	}

	public void setDepositDescription(String depositDescription) {
		this.depositDescription = depositDescription;
	}

	public int getPlusDeposit() {
		return plusDeposit;
	}

	public void setPlusDeposit(int plusDeposit) {
		this.plusDeposit = plusDeposit;
	}

	public int getMinusDeposit() {
		return minusDeposit;
	}

	public void setMinusDeposit(int minusDeposit) {
		this.minusDeposit = minusDeposit;
	}

	public int getCurrentDeposit() {
		return currentDeposit;
	}

	public void setCurrentDeposit(int currentDeposit) {
		this.currentDeposit = currentDeposit;
	}

	public String getDepositUpdateDate() {
		return depositUpdateDate;
	}

	public void setDepositUpdateDate(String depositUpdateDate) {
		this.depositUpdateDate = depositUpdateDate;
	}
	
	
	
}
