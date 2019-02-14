package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Name","TRA_DATE","Val_DATE","Narration","Currency","TRA_AMT","TRA_TYPE","DR_AMT",
	"CR_AMT","START_BAL","TRA_BAL"})
public class TransactionDetails {
	private String Name;
	private String TRA_DATE;
	private String Val_DATE;
	private String Narration;
	private String Currency;
	private String TRA_AMT;
	private String TRA_TYPE;
	private String DR_AMT;
	private String CR_AMT;
	private String START_BAL;
	private String TRA_BAL;
	
	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@JsonProperty("TRA_DATE")
	public String getTRA_DATE() {
		return TRA_DATE;
	}
	public void setTRA_DATE(String tRA_DATE) {
		TRA_DATE = tRA_DATE;
	}
	
	@JsonProperty("Val_DATE")
	public String getVal_DATE() {
		return Val_DATE;
	}
	public void setVal_DATE(String val_DATE) {
		Val_DATE = val_DATE;
	}
	
	@JsonProperty("Narration")
	public String getNarration() {
		return Narration;
	}
	public void setNarration(String narration) {
		Narration = narration;
	}
	
	@JsonProperty("Currency")
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		this.Currency = currency;
	}
	
	@JsonProperty("TRA_AMT")
	public String getTRA_AMT() {
		return TRA_AMT;
	}
	public void setTRA_AMT(String tRA_AMT) {
		TRA_AMT = tRA_AMT;
	}
	
	@JsonProperty("TRA_TYPE")
	public String getTRA_TYPE() {
		return TRA_TYPE;
	}
	public void setTRA_TYPE(String tRA_TYPE) {
		TRA_TYPE = tRA_TYPE;
	}
	
	@JsonProperty("DR_AMT")
	public String getDR_AMT() {
		return DR_AMT;
	}
	public void setDR_AMT(String dR_AMT) {
		DR_AMT = dR_AMT;
	}
	
	@JsonProperty("CR_AMT")
	public String getCR_AMT() {
		return CR_AMT;
	}
	public void setCR_AMT(String cR_AMT) {
		CR_AMT = cR_AMT;
	}
	
	@JsonProperty("START_BAL")
	public String getSTART_BAL() {
		return START_BAL;
	}
	public void setSTART_BAL(String sTART_BAL) {
		START_BAL = sTART_BAL;
	}
	
	@JsonProperty("TRA_BAL")
	public String getTRA_BAL() {
		return TRA_BAL;
	}
	public void setTRA_BAL(String tRA_BAL) {
		TRA_BAL = tRA_BAL;
	}
}
