package com.ubn.ciss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "access_token","expires_in","refresh_token", "token_type","scope","jti"})
public class OauthResponse {

	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String token_type;
	private String scope;
	private String jti;
	
	@JsonProperty("access_token")
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	@JsonProperty("expires_in")
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	@JsonProperty("refresh_token")
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	@JsonProperty("token_type")
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	@JsonProperty("jti")
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
}
