package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignatoriesWithNIN extends Signatories{

	private String NIN;

	@JsonProperty("NIN")
	public String getNIN() {
		return NIN;
	}

	public void setNIN(String NIN) {
		this.NIN = NIN;
	}
	
	
}
