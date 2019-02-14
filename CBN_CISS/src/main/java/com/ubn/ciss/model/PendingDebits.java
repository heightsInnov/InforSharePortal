package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"BeneficiaryAccountNo","BeneficiaryBank","InitiatedDate","PaymentDate","Type"})
public class PendingDebits {

	private String BeneficiaryAccountNo;
	private String BeneficiaryBank;
	private String InitiatedDate;
	private String PaymentDate;
	private String Type;
	
	
	public PendingDebits() {}


	@JsonProperty("BeneficiaryAccountNo")
	public String getBeneficiaryAccountNo() {
		return BeneficiaryAccountNo;
	}


	public void setBeneficiaryAccountNo(String BeneficiaryAccountNo) {
		this.BeneficiaryAccountNo = BeneficiaryAccountNo;
	}

	@JsonProperty("BeneficiaryBank")
	public String getBeneficiaryBank() {
		return BeneficiaryBank;
	}


	public void setBeneficiaryBank(String BeneficiaryBank) {
		this.BeneficiaryBank = BeneficiaryBank;
	}

	@JsonProperty("InitiatedDate")
	public String getInitiatedDate() {
		return InitiatedDate;
	}


	public void setInitiatedDate(String InitiatedDate) {
		this.InitiatedDate = InitiatedDate;
	}

	@JsonProperty("PaymentDate")
	public String getPaymentDate() {
		return PaymentDate;
	}


	public void setPaymentDate(String PaymentDate) {
		this.PaymentDate = PaymentDate;
	}

	@JsonProperty("Type")
	public String getType() {
		return Type;
	}


	public void setType(String Type) {
		this.Type = Type;
	}


	
	
	
}
