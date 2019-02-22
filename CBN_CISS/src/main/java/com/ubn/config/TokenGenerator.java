package com.ubn.config;

import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ubn.ciss.model.OauthResponse;

@Component
public class TokenGenerator {

	@Value("${clientSecret}")
	private String clientSecret;
	@Value("${clientId}")
	private String clientId;
	@Value("${grantType}")
	private String grantType;
	@Value("${baseUrlMiserv}")
	private String baseUrlMiserv;

	private static Logger logger = LoggerFactory.getLogger(TokenGenerator.class.getName());

	// -----Setting time out for service operation
	private static ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(100000);
		factory.setConnectTimeout(100000);
		return factory;
	}

	public OauthResponse getToken(String user, String pass) {
		OauthResponse resp = new OauthResponse();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

			String TOKEN_REST_URL = baseUrlMiserv + "client_secret=" + clientSecret + "&client_id=" + clientId
					+ "&grant_type=" + grantType + "&username=" + user + "&password=" + pass;

			// Send request with POST method, and Headers.
			ResponseEntity<String> response = restTemplate.postForEntity(TOKEN_REST_URL, HttpMethod.POST, String.class);
			String result = response.getBody();

			if (result != null) {
				if (result.startsWith("{")) {
					JSONObject jsonObject = new JSONObject(result);
					if (jsonObject.has("access_token")) {
						resp.setAccess_token(jsonObject.getString("access_token"));
						resp.setExpires_in(jsonObject.getString("expires_in"));
						resp.setRefresh_token(jsonObject.getString("refresh_token"));
						resp.setToken_type(jsonObject.getString("token_type"));
						resp.setScope(jsonObject.getString("scope"));
						resp.setJti(jsonObject.getString("jti"));
					}
				}
			} else {
				resp = null;
				logger.error(new Date() + "::Method::getToken::Response::" + response);
			}
		} catch (Exception e) {
			logger.error(new Date() + "::Method::getToken::Response::" + e.getMessage());
		}
		return resp;
	}
}
