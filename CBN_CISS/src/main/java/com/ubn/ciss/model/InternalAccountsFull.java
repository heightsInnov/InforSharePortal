package com.ubn.ciss.model;

public class InternalAccountsFull extends InternalAccounts{

	private String status;
	private String Currency;
	private String Description;
	private String TRA_BAL;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public String getTRA_BAL() {
		return TRA_BAL;
	}
	public void setTRA_BAL(String TRA_BAL) {
		this.TRA_BAL = TRA_BAL;
	}
}
