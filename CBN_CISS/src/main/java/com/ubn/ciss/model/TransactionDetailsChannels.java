package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetailsChannels extends TransactionDetails{

	private String TRA_CHANNEL;
	private String Payment_type;
	
	@JsonProperty("TRA_CHANNEL")
	public String getTRA_CHANNEL() {
		return TRA_CHANNEL;
	}
	public void setTRA_CHANNEL(String TRA_CHANNEL) {
		this.TRA_CHANNEL = TRA_CHANNEL;
	}
	
	@JsonProperty("Payment_type")
	public String getPayment_Type() {
		return Payment_type;
	}
	public void setPayment_Type(String Payment_type) {
		this.Payment_type = Payment_type;
	}

}
