package com.ubn.ciss.model;

public class ListAccountsByBVN {

	private String Nuban;
	private String Bank_Code;
	private String AVL_BAL;
	private String Currency;
	
	public String getNuban() {
		return Nuban;
	}
	public void setNuban(String nuban) {
		Nuban = nuban;
	}
	public String getBank_Code() {
		return Bank_Code;
	}
	public void setBank_Code(String bank_Code) {
		Bank_Code = bank_Code;
	}
	public String getAVL_BAL() {
		return AVL_BAL;
	}
	public void setAVL_BAL(String aVL_BAL) {
		AVL_BAL = aVL_BAL;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
}
