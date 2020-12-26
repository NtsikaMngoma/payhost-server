package za.co.payhost.server.api.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RestController;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import za.co.payhost.server.api.service.SmsService;


public class SmsServiceImpl implements SmsService {
    private final Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

	@Value("${smsportal.key}")
	public String apiKey;
	
	@Value("${smsportal.secret}")
	public String apiSecret;
	
	@Value("${smsportal.auth.address}")
	public String authAddress;
	
	@Value("${smsportal.message.request}")
	public String messageRequestUri;

	@Override
	public void sendSms(String transactionStatusDescription) throws IOException, JSONException {
		// TODO Auto-generated method stub
		OkHttpClient client = new OkHttpClient();
		String accountApiCredentails = apiKey + ":" + apiSecret;
		byte[] plainTestBytes = accountApiCredentails.getBytes();
		String base64Credentails = Base64Utils.encodeToString(plainTestBytes);
		
		Request authRequest = new Request.Builder()
				.url(authAddress)
				.header("Authorization", String.format("Basic %s", base64Credentails))
				.get()
				.build();
		
		Response authResponse = client.newCall(authRequest).execute();
		String authTokenString = "";
		String jsonObjectString = "";
		
		if (authResponse.code() == 200) {
			com.squareup.okhttp.ResponseBody authResponseBody = authResponse.body();
			jsonObjectString = authResponseBody.string();
		} 
		
		RequestBody sendSms = RequestBody.create(
				MediaType.parse("application/json; charset=utf-8"),
				"{\n" +
			               "  \"messages\": [\n" +
			               "    {\n" +
			               "      \"content\": \"" + "Payment: " + transactionStatusDescription + "\",\n" +
			               "      \"destination\": \"" + "0822832834" + "\"\n" +
			               "    }\n" +
			               "  ]\n" +
			               "}");
		
		JSONObject jsonObj = new JSONObject(jsonObjectString);
		authTokenString = jsonObj.getString("token");
		
		String authHeader = String.format("Bearer %s", authTokenString);
		Request sendRequest = new Request.Builder()
				.url(messageRequestUri)
				.header("Authorization", authHeader)
				.post(sendSms)
				.build();
		try {
			Response sendResponse = client.newCall(sendRequest).execute();
			log.info(sendResponse.body().string());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("REST Call Failed!");
			e.printStackTrace();
		}
	}

	@Override
	public void sendOtp() {
		// TODO Auto-generated method stub
		
	}
}
