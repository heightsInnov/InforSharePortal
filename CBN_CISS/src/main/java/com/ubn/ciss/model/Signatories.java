package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Name","BVN","Date_of_birth"})
public class Signatories {

	private String Name;
	private String BVN;
	private String Date_of_birth;
	
	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@JsonProperty("BVN")
	public String getBVN() {
		return BVN;
	}
	public void setBVN(String bVN) {
		BVN = bVN;
	}
	
	@JsonProperty("Date_of_birth")
	public String getDate_of_birth() {
		return Date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		Date_of_birth = date_of_birth;
	}
}
