package com.ubn.ciss.model;

public class ListStatistics extends cbnResponse2{

	private String ActiveAccounts;
	private String ActiveCorporate;
	private String Activeindividual;
	private String ActiveTier1;
	private String ActiveTier2;
	private String ActiveTier3;
	
	public String getActiveAccounts() {
		return ActiveAccounts;
	}
	public void setActiveAccounts(String ActiveAccounts) {
		this.ActiveAccounts = ActiveAccounts;
	}
	public String getActiveCorporate() {
		return ActiveCorporate;
	}
	public void setActiveCorporate(String ActiveCorporate) {
		this.ActiveCorporate = ActiveCorporate;
	}
	public String getActiveindividual() {
		return Activeindividual;
	}
	public void setActiveindividual(String Activeindividual) {
		this.Activeindividual = Activeindividual;
	}
	public String getActiveTier1() {
		return ActiveTier1;
	}
	public void setActiveTier1(String ActiveTier1) {
		this.ActiveTier1 = ActiveTier1;
	}
	public String getActiveTier2() {
		return ActiveTier2;
	}
	public void setActiveTier2(String ActiveTier2) {
		this.ActiveTier2 = ActiveTier2;
	}
	public String getActiveTier3() {
		return ActiveTier3;
	}
	public void setActiveTier3(String ActiveTier3) {
		this.ActiveTier3 = ActiveTier3;
	}
}
