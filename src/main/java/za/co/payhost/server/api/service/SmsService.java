package za.co.payhost.server.api.service;

import java.io.IOException;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface SmsService {

	void sendOtp();
	void sendSms(String transactionStatusDescription) throws IOException, JSONException;
	void saveSmsStatus();
}
