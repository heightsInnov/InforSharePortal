package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","Msg","DormantAccounts","DormantAccountsAmt","DormantCorporate","DormantCorpAccountsAmt",
	"DormantIndividual","DormantIndAccountsAmt","DormantTier1","DormantTier2","DormantTier3"})
public class DormantStatistics extends cbnResponse2{

	private String DormantAccounts;
	private String DormantAccountsAmt;
	private String DormantCorporate;
	private String DormantCorpAccountsAmt;
	private String DormantIndividual;
	private String DormantIndAccountsAmt;
	private String DormantTier1;
	private String DormantTier2;
	private String DormantTier3;
	
	
	public DormantStatistics() {}

	@JsonProperty("DormantAccounts")
	public String getDormantAccounts() {
		return DormantAccounts;
	}

	public void setDormantAccounts(String DormantAccounts) {
		this.DormantAccounts = DormantAccounts;
	}

	@JsonProperty("DormantAccountsAmt")
	public String getDormantAccountsAmt() {
		return DormantAccountsAmt;
	}

	public void setDormantAccountsAmt(String DormantAccountsAmt) {
		this.DormantAccountsAmt = DormantAccountsAmt;
	}

	@JsonProperty("DormantCorporate")
	public String getDormantCorporate() {
		return DormantCorporate;
	}

	public void setDormantCorporate(String DormantCorporate) {
		this.DormantCorporate = DormantCorporate;
	}

	@JsonProperty("DormantCorpAccountsAmt")
	public String getDormantCorpAccountsAmt() {
		return DormantCorpAccountsAmt;
	}

	public void setDormantCorpAccountsAmt(String DormantCorpAccountsAmt) {
		this.DormantCorpAccountsAmt = DormantCorpAccountsAmt;
	}

	@JsonProperty("DormantIndividual")
	public String getDormantIndividual() {
		return DormantIndividual;
	}

	public void setDormantIndividual(String DormantIndividual) {
		this.DormantIndividual = DormantIndividual;
	}

	@JsonProperty("DormantIndAccountsAmt")
	public String getDormantIndAccountsAmt() {
		return DormantIndAccountsAmt;
	}

	public void setDormantIndAccountsAmt(String DormantIndAccountsAmt) {
		this.DormantIndAccountsAmt = DormantIndAccountsAmt;
	}

	@JsonProperty("DormantTier1")
	public String getDormantTier1() {
		return DormantTier1;
	}

	public void setDormantTier1(String DormantTier1) {
		this.DormantTier1 = DormantTier1;
	}

	@JsonProperty("DormantTier2")
	public String getDormantTier2() {
		return DormantTier2;
	}

	public void setDormantTier2(String DormantTier2) {
		this.DormantTier2 = DormantTier2;
	}

	@JsonProperty("DormantTier3")
	public String getDormantTier3() {
		return DormantTier3;
	}

	public void setDormantTier3(String DormantTier3) {
		this.DormantTier3 = DormantTier3;
	}


	
	
}
