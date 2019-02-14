package com.ubn.ciss.model;

public class AccountDetails extends cbnResponse2{

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
	private String Restriction_Status;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getRestriction_Status() {
		return Restriction_Status;
	}
	public void setRestriction_Status(String Restriction_Status) {
		this.Restriction_Status = Restriction_Status;
	}
	public String getBVN() {
		return BVN;
	}
	public void setBVN(String bVN) {
		BVN = bVN;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getTier() {
		return Tier;
	}
	public void setTier(String tier) {
		Tier = tier;
	}
	public String getCLR_BAL() {
		return CLR_BAL;
	}
	public void setCLR_BAL(String cLR_BAL) {
		CLR_BAL = cLR_BAL;
	}
	public String getAVL_BAL() {
		return AVL_BAL;
	}
	public void setAVL_BAL(String aVL_BAL) {
		AVL_BAL = aVL_BAL;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getAOD() {
		return AOD;
	}
	public void setAOD(String aOD) {
		AOD = aOD;
	}
	public String getAccount_Status() {
		return Account_Status;
	}
	public void setAccount_Status(String account_Status) {
		Account_Status = account_Status;
	}
}
