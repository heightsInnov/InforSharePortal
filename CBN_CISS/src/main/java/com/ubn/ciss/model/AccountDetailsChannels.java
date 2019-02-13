package com.ubn.ciss.model;

public class AccountDetailsChannels extends AccountDetails{

	private String Tax_ID_Number;
	private String RC_Number;
	private String NIN;
	
	public String getTax_ID_Number() {
		return Tax_ID_Number;
	}
	public void setTax_ID_Number(String tax_ID_Number) {
		Tax_ID_Number = tax_ID_Number;
	}
	public String getRC_Number() {
		return RC_Number;
	}
	public void setRC_Number(String rC_Number) {
		RC_Number = rC_Number;
	}
	public String getNIN() {
		return NIN;
	}
	public void setNIN(String nIN) {
		NIN = nIN;
	}
}
