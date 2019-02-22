package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status","Msg","Name", "Type", "Category", "Tier", "CLR_BAL", "AVL_BAL", "AccountNo", "Address", "Email",
		"Telephone", "Currency", "AOD", "BVN", "Account_Status", "RestrictionStatus" })
public class AccountDetails extends cbnResponse2 {

	private String Name;
	private String Type;
	private String Category;
	private String Tier;
	private String CLR_BAL;
	private String AVL_BAL;
	private String AccountNo;
	private String Address;
	private String Email;
	private String Telephone;
	private String Currency;
	private String AOD;
	private String BVN;
	private String Account_Status;
	private String RestrictionStatus;

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@JsonProperty("Type")
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@JsonProperty("RestrictionStatus")
	public String getRestriction_Status() {
		return RestrictionStatus;
	}

	public void setRestriction_Status(String Restriction_Status) {
		this.RestrictionStatus = Restriction_Status;
	}

	@JsonProperty("BVN")
	public String getBVN() {
		return BVN;
	}

	public void setBVN(String bVN) {
		BVN = bVN;
	}

	@JsonProperty("Category")
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@JsonProperty("Tier")
	public String getTier() {
		return Tier;
	}

	public void setTier(String tier) {
		Tier = tier;
	}

	@JsonProperty("CLR_BAL")
	public String getCLR_BAL() {
		return CLR_BAL;
	}

	public void setCLR_BAL(String cLR_BAL) {
		CLR_BAL = cLR_BAL;
	}

	@JsonProperty("AVL_BAL")
	public String getAVL_BAL() {
		return AVL_BAL;
	}

	public void setAVL_BAL(String aVL_BAL) {
		AVL_BAL = aVL_BAL;
	}

	@JsonProperty("AccountNo")
	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}

	@JsonProperty("Address")
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@JsonProperty("Email")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@JsonProperty("Telephone")
	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	@JsonProperty("Currency")
	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	@JsonProperty("AOD")
	public String getAOD() {
		return AOD;
	}

	public void setAOD(String aOD) {
		AOD = aOD;
	}

	@JsonProperty("Account_Status")
	public String getAccount_Status() {
		return Account_Status;
	}

	public void setAccount_Status(String account_Status) {
		Account_Status = account_Status;
	}
}
