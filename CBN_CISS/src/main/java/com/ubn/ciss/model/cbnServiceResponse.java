package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","Msg","Result"})
public class cbnServiceResponse {

	private String status;
	private String Msg;
	private Object Result;
	
	/**
	 * @param status
	 * @param msg
	 * @param result
	 */
	public cbnServiceResponse(String status, String msg, Object result) {
		super();
		this.status = status;
		Msg = msg;
		Result = result;
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
	public void setMsg(String msg) {
		Msg = msg;
	}
	
	@JsonProperty("Result")
	public Object getResult() {
		return Result;
	}
	public void setResult(Object result) {
		Result = result;
	}
}
