package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Nuban","BankCode","AVL_BAL","Currency"})
public class ListAccountsByBVN {

	private String Nuban;
	private String BankCode;
	private String AVL_BAL;
	private String Currency;
	
	@JsonProperty("Nuban")
	public String getNuban() {
		return Nuban;
	}
	public void setNuban(String Nuban) {
		this.Nuban = Nuban;
	}
	
	@JsonProperty("BankCode")
	public String getBank_Code() {
		return BankCode;
	}
	public void setBank_Code(String BankCode) {
		this.BankCode = BankCode;
	}
	
	@JsonProperty("AVL_BAL")
	public String getAVL_BAL() {
		return AVL_BAL;
	}
	public void setAVL_BAL(String AVL_BAL) {
		this.AVL_BAL = AVL_BAL;
	}
	
	@JsonProperty("Currency")
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
}
