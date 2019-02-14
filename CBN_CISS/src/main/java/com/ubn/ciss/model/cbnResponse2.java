package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class cbnResponse2 {

	private String status;
	private String Msg;
	
	public cbnResponse2() {}

	public cbnResponse2(String status, String Msg) {
		super();
		this.status = status;
		this.Msg = Msg;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("Msg")
	public String getMsg() {
		return Msg;
	}

	public void setMsg(String Msg) {
		this.Msg = Msg;
	}
}
