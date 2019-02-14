package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Nuban","TIN","RCNumber"})
public class ListTIN_RCNo {

	String Nuban;
	String TIN;
	String RCNumber;
	
	public ListTIN_RCNo() {}

	@JsonProperty("Nuban")
	public String getNuban() {
		return this.Nuban;
	}

	public void setNuban(String Nuban) {
		this.Nuban = Nuban;
	}

	@JsonProperty("TIN")
	public String getTIN() {
		return this.TIN;
	}

	public void setTIN(String TIN) {
		this.TIN = TIN;
	}

	@JsonProperty("RCNumber")
	public String getRCNumber() {
		return this.RCNumber;
	}

	public void setRCNumber(String RCNumber) {
		this.RCNumber = RCNumber;
	}
	
	
}
