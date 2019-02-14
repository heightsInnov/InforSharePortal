package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","Msg","Percentage"})
public class ActiveTIN {

	private String status;
	private String Msg;
	private String Percentage;
	
	
	/**
	 * @param status
	 * @param msg
	 * @param percentage
	 */
	public ActiveTIN(String status, String Msg, String Percentage) {
		super();
		this.status = status;
		this.Msg = Msg;
		this.Percentage = Percentage;
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
	@JsonProperty("Percentage")
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String Percentage) {
		this.Percentage = Percentage;
	}
}
