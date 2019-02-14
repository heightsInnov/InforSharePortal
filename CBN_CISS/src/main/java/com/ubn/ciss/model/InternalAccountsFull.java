package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","Currency","Description","TRA_BAL"})
public class InternalAccountsFull extends InternalAccounts{

	private String status;
	private String Currency;
	private String Description;
	private String TRA_BAL;
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("Currency")
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
	
	@JsonProperty("Description")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	@JsonProperty("TRA_BAL")
	public String getTRA_BAL() {
		return TRA_BAL;
	}
	public void setTRA_BAL(String TRA_BAL) {
		this.TRA_BAL = TRA_BAL;
	}
}
