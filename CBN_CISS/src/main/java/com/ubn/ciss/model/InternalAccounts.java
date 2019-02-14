package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalAccounts {

	private String AccountNo;

	@JsonProperty("AccountNo")
	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}
}
