package com.ubn.ciss.model;

public class ListAccountsByBVN {

	private String Nuban;
	private String BankCode;
	private String AVL_BAL;
	private String Currency;
	
	public String getNuban() {
		return Nuban;
	}
	public void setNuban(String Nuban) {
		this.Nuban = Nuban;
	}
	public String getBank_Code() {
		return BankCode;
	}
	public void setBank_Code(String BankCode) {
		this.BankCode = BankCode;
	}
	public String getAVL_BAL() {
		return AVL_BAL;
	}
	public void setAVL_BAL(String AVL_BAL) {
		this.AVL_BAL = AVL_BAL;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
}
