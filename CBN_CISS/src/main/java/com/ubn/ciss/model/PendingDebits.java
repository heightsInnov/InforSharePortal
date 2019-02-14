package com.ubn.ciss.model;

public class PendingDebits {

	private String BeneficiaryAccountNo;
	private String BeneficiaryBank;
	private String InitiatedDate;
	private String PaymentDate;
	private String Type;
	
	
	public PendingDebits() {}


	public String getBeneficiaryAccountNo() {
		return BeneficiaryAccountNo;
	}


	public void setBeneficiaryAccountNo(String BeneficiaryAccountNo) {
		this.BeneficiaryAccountNo = BeneficiaryAccountNo;
	}


	public String getBeneficiaryBank() {
		return BeneficiaryBank;
	}


	public void setBeneficiaryBank(String BeneficiaryBank) {
		this.BeneficiaryBank = BeneficiaryBank;
	}


	public String getInitiatedDate() {
		return InitiatedDate;
	}


	public void setInitiatedDate(String InitiatedDate) {
		this.InitiatedDate = InitiatedDate;
	}


	public String getPaymentDate() {
		return PaymentDate;
	}


	public void setPaymentDate(String PaymentDate) {
		this.PaymentDate = PaymentDate;
	}


	public String getType() {
		return Type;
	}


	public void setType(String Type) {
		this.Type = Type;
	}


	
	
	
}
