package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "ClosedAccounts", "ClosedCorporate", "ClosedIndividual", "ClosedTier1", "ClosedTier2",
		"ClosedTier3" })
public class ClosedStatistics extends cbnResponse2 {

	private String ClosedAccounts;
	private String ClosedCorporate;
	private String ClosedIndividual;
	private String ClosedTier1;
	private String ClosedTier2;
	private String ClosedTier3;

	public ClosedStatistics() {
	}

	@JsonProperty("ClosedAccounts")
	public String getClosedAccounts() {
		return ClosedAccounts;
	}

	public void setClosedAccounts(String ClosedAccounts) {
		this.ClosedAccounts = ClosedAccounts;
	}

	@JsonProperty("ClosedCorporate")
	public String getClosedCorporate() {
		return ClosedCorporate;
	}

	public void setClosedCorporate(String ClosedCorporate) {
		this.ClosedCorporate = ClosedCorporate;
	}

	@JsonProperty("ClosedIndividual")
	public String getClosedIndividual() {
		return ClosedIndividual;
	}

	public void setClosedIndividual(String ClosedIndividual) {
		this.ClosedIndividual = ClosedIndividual;
	}

	@JsonProperty("ClosedTier1")
	public String getClosedTier1() {
		return ClosedTier1;
	}

	public void setClosedTier1(String ClosedTier1) {
		this.ClosedTier1 = ClosedTier1;
	}

	@JsonProperty("ClosedTier2")
	public String getClosedTier2() {
		return ClosedTier2;
	}

	public void setClosedTier2(String ClosedTier2) {
		this.ClosedTier2 = ClosedTier2;
	}

	@JsonProperty("ClosedTier3")
	public String getClosedTier3() {
		return ClosedTier3;
	}

	public void setClosedTier3(String ClosedTier3) {
		this.ClosedTier3 = ClosedTier3;
	}
}
