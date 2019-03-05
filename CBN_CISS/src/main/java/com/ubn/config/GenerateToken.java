package com.ubn.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpHeaders;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import com.ubn.bypass.HttpsServiceCertificateByPasser;
import com.ubn.ciss.model.OauthResponse;
import com.ubn.ciss.utils.Utility;

@Component
public class GenerateToken {
	
	@Value("${clientSecret}")
	private String clientSecret;
	@Value("${clientId}")
	private String clientId;
	@Value("${grantType}")
	private String grantType;
	
	private String baseUrlMiserv;

	HttpsURLConnection con = null;

	private HttpsServiceCertificateByPasser hscbp = new HttpsServiceCertificateByPasser();

	HttpHeaders headers;

	private static Logger logger = LoggerFactory.getLogger(GenerateToken.class.getName());

	@SuppressWarnings("unused")
	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(10000);
		factory.setConnectTimeout(10000);
		return factory;
	}

	public OauthResponse getToken(String username, String password) throws IOException {
        String accesstoken = null;
        OauthResponse resp = new OauthResponse();
        baseUrlMiserv = Utility.getPropertiesValue("baseUrlMiserv");

        try {
            hscbp.disableCertificateValidation();
            
            String TOKEN_REST_URL = baseUrlMiserv+"username="+username+"&password="+password+"&client_id="+clientId+"&client_secret="+clientSecret+"&grant_type=password";
//            		"http://10.65.0.123:7001/ubnmiserv/oauth/token";
            
            
            @SuppressWarnings("restriction")
            URL url = new URL(null, TOKEN_REST_URL, new sun.net.www.protocol.https.Handler());
            con = (HttpsURLConnection)url.openConnection();
            
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoInput(true);
            con.setDoOutput(true);

            JSONObject jsonEntity = new JSONObject();
            
            OutputStream os = con.getOutputStream();
            os.write(jsonEntity.toString().getBytes());
            os.flush();

            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                String reader;
                String response = null;
                while ((reader = br.readLine()) != null) {
                    response = reader;
                }
                if (response != null) {
                    if (response.startsWith("{")) {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.has("access_token")) {
                        	resp.setAccess_token(jsonObject.getString("access_token"));
    						resp.setRefresh_token(jsonObject.getString("refresh_token"));
    						resp.setToken_type(jsonObject.getString("token_type"));
    						resp.setScope(jsonObject.getString("scope"));
    						resp.setJti(jsonObject.getString("jti"));
    						resp.setExpires_in(String.valueOf(jsonObject.getInt("expires_in")));
                            accesstoken = jsonObject.getString("access_token");
                            System.out.println("accesstoken= " + accesstoken);
                        }
                    }
                }
                con.disconnect();
            }

        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("getToken::Response==== " + e.getMessage());
        }
        return resp;
    }
	
//	public static void main(String[] args) {
//		GenerateToken g = new GenerateToken();
//		try {
//			System.out.println(g.getToken("", ""));
//		}catch(IOException i) {
//			
//		}
//	}
}
