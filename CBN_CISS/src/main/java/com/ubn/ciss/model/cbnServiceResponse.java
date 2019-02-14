package com.ubn.ciss.model;

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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public Object getResult() {
		return Result;
	}
	public void setResult(Object result) {
		Result = result;
	}
}
