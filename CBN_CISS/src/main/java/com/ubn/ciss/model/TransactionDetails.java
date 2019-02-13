package com.ubn.ciss.model;

public class TransactionDetails {
	private String tra_Date;
	private String val_Date;
	private String currency;
	private String tra_Amt;
	private String tra_Type;
	private String Narration;
	private String tra_Bal;
	
	public String getTra_Date() {
		return tra_Date;
	}
	public void setTra_Date(String tra_Date) {
		this.tra_Date = tra_Date;
	}
	public String getVal_Date() {
		return val_Date;
	}
	public void setVal_Date(String val_Date) {
		this.val_Date = val_Date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTra_Amt() {
		return tra_Amt;
	}
	public void setTra_Amt(String tra_Amt) {
		this.tra_Amt = tra_Amt;
	}
	public String getTra_Type() {
		return tra_Type;
	}
	public void setTra_Type(String tra_Type) {
		this.tra_Type = tra_Type;
	}
	public String getNarration() {
		return Narration;
	}
	public void setNarration(String narration) {
		Narration = narration;
	}
	public String getTra_Bal() {
		return tra_Bal;
	}
	public void setTra_Bal(String tra_Bal) {
		this.tra_Bal = tra_Bal;
	}
}
