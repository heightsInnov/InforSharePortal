package com.ubn.ciss.model;

public class TransactionDetailsChannels extends TransactionDetails{

	private String Tra_Channel;
	private String Payment_Type;
	
	public String getTra_Channel() {
		return Tra_Channel;
	}
	public void setTra_Channel(String tra_Channel) {
		Tra_Channel = tra_Channel;
	}
	public String getPayment_Type() {
		return Payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		Payment_Type = payment_Type;
	}

}
