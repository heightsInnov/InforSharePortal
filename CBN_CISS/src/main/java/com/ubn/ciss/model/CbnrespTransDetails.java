package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","Msg","Name","Result"})
public class CbnrespTransDetails {

	
	private String status;
	private String Msg;
	private String Name;
	private Object Result;
	
	public CbnrespTransDetails() {}

	public CbnrespTransDetails(String status, String msg, String name, Object result) {
		super();
		this.status = status;
		Msg = msg;
		Name = name;
		Result = result;
	}



	@JsonProperty("Result")
	public Object getResult() {
		return Result;
	}

	public void setResult(Object result) {
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

	public void setMsg(String Msg) {
		this.Msg = Msg;
	}
	
	@JsonProperty("Name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

}
