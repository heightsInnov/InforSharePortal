package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRequest {

	@JsonProperty("StartDate")
	private String startDate;
	@JsonProperty("EndDate")
	private String endDate;
	@JsonProperty("AccountNo")
	private String accountNo;
	@JsonProperty("BVN")
	private String bvn;
	@JsonProperty("RCNo")
	private String rcNo;
	@JsonProperty("TIN")
	private String tin;
	@JsonProperty("NIN")
	private String nin;
	@JsonProperty("LedgerCode")
	private String ledgerCode;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLedgerCode() {
		return ledgerCode;
	}
	public void setLedgerCode(String ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBvn() {
		return bvn;
	}
	public void setBvn(String bvn) {
		this.bvn = bvn;
	}
	public String getRcNo() {
		return rcNo;
	}
	public void setRcNo(String rcNo) {
		this.rcNo = rcNo;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getNin() {
		return nin;
	}
	public void setNin(String nin) {
		this.nin = nin;
	}
	
	}
