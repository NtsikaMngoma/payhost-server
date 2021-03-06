package za.co.payhost.server.api.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.co.paygate.payhost.*;
import za.co.payhost.server.api.service.PaymentService;
import za.co.payhost.server.api.service.SmsService;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;
import za.co.payhost.server.api.soapclient.CardPaymentClient;
import za.co.payhost.server.api.utils.PaymentFailedException;
import za.co.payhost.server.api.utils.ResponseUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;

/**
 * @author Ntsika Mngoma
 *
 */
@RestController
@RequestMapping("/transact")
public class CardPaymentResource {
	private final Logger log = LoggerFactory.getLogger(CardPaymentResource.class);
	private static final String ENTITY_NAME = "PaymentTransactions";
	@Value("${application.name}")
	private String applicationName;
	
	@Value("${paygate.endpoint}")
	public String payGateUrl;

	private final CardPaymentClient cardPaymentClient;
	private final PaymentService paymentService;
	private final SmsService smsService;

	@Autowired
	public CardPaymentResource(CardPaymentClient cardPaymentClient, PaymentService paymentService, SmsService smsService) {
		this.cardPaymentClient = cardPaymentClient;
		this.paymentService = paymentService;
		this.smsService = smsService;
	}

	@GetMapping(value = "/example", produces = "application/json")
	public ResponseEntity<String> GetCall() {
		return ResponseEntity.ok(form());
	}
	
	/**
	 * @param request POST 
	 * @return cardPaymentResponse
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws DatatypeConfigurationException 
	 */
	@PostMapping(value = "/card-payment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SinglePaymentResponse> processPayment(@RequestBody SinglePaymentRequest request) throws IOException, JSONException, DatatypeConfigurationException {
		SinglePaymentResponse responseString = cardPaymentClient.cardPaymentService(request);
		String smsMessageString = responseString.getCardPaymentResponse().getStatus().getTransactionStatusDescription();
		smsService.sendSms(smsMessageString);
		smsService.saveSmsStatus();
		PaymentTransactionsDTO paymentTransactionsDTO = new PaymentTransactionsDTO();
		paymentService.saveTransactionResults(responseString, paymentTransactionsDTO);
		paymentService.save(paymentTransactionsDTO, request);
		if (paymentTransactionsDTO.getPaymentTypeId().equals(null) || paymentTransactionsDTO.getPayRequestId().equals(null)) {
			throw new PaymentFailedException("Your payment could be processed");
		}
		return ResponseEntity.ok(responseString);		
    }
	
	/**
	 * @param vaultRequest
	 * @return
	 */
	@PostMapping(value = "/vault-request", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SingleVaultResponse> processVault(@RequestBody SingleVaultRequest vaultRequest) {
		return ResponseEntity.ok(cardPaymentClient.vaultService(vaultRequest));
	}
	
	/**
	 * @param lookRequest
	 * @return
	 */
	@GetMapping(value = "/vault-lookup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SingleVaultResponse> lookUpVaultIdByCreds(@RequestBody SingleVaultRequest lookRequest) {
		return ResponseEntity.ok(cardPaymentClient.vaultService(lookRequest));
	}

	@GetMapping(value = "/list-by-mail", produces = "application/json")
	public ResponseEntity<PaymentTransactionsDTO> getTransactionMail(@Param("email_address") String emailAddress) {
		log.debug("REST request to get transaction : {}", emailAddress);
		Optional<PaymentTransactionsDTO> paymentTransaction = paymentService.listByEmailAddress(emailAddress);
		return ResponseUtil.wrapOrNotFound(paymentTransaction);
	}

	@GetMapping(value = "/list-by-id/{id}", produces = "application/json")
	public ResponseEntity<PaymentTransactionsDTO> getTransactionId(@PathVariable Long id) {
		log.debug("REST request to get transaction : {}", id);
		Optional<PaymentTransactionsDTO> paymentTransaction = paymentService.listOne(id);
		return ResponseUtil.wrapOrNotFound(paymentTransaction);
	}

	@GetMapping(value = "/list-by-reference", produces = "application/json")
	public ResponseEntity<PaymentTransactionsDTO> getTransactionReference(@Param("reference_id") String referenceId) {
		log.debug("REST request to get transaction : {}", referenceId);
		Optional<PaymentTransactionsDTO> paymentTransaction = paymentService.retrieveByReferenceId(referenceId);
		return ResponseUtil.wrapOrNotFound(paymentTransaction);
	}

	@GetMapping(value = "/list-by-surname", produces = "application/json")
	public ResponseEntity<PaymentTransactionsDTO> getTransactionSurname(@Param("surname") String surname) {
		log.debug("REST request to get transaction : {}", surname);
		Optional<PaymentTransactionsDTO> paymentTransaction = paymentService.listBySurname(surname);
		return ResponseUtil.wrapOrNotFound(paymentTransaction);
	}

	@GetMapping(value = "/payments")
	public List<PaymentTransactionsDTO> getAllTransactions() {
		log.debug("REST request to get all transactions");
		return paymentService.listAll();
	}


	public String form() {
		return "{\n" +
				"  \"cardPaymentRequest\": {\n" +
				"    \"account\": {\n" +
				"      \"password\": \"test\",\n" +
				"      \"payGateId\": \"10011064270\"\n" +
				"    },\n" +
				"    \"budgetPeriod\": 0,\n" +
				"    \"cardExpiryDate\": \"122021\",\n" +
				"    \"cardNumber\": \"378282246310005\",\n" +
				"    \"customer\": {\n" +
				"      \"email\": [\n" +
				"        \"markmngoma@outlook.com\"\n" +
				"      ],\n" +
				"      \"firstName\": \"string\",\n" +
				"      \"idNumber\": \"string\",\n" +
				"      \"lastName\": \"string\",\n" +
				"      \"middleName\": \"string\",\n" +
				"      \"mobile\": [\n" +
				"        \"string\"\n" +
				"      ],\n" +
				"      \"title\": \"Mr\"\n" +
				"    },\n" +
				"    \"cvv\": \"456\",\n" +
				"    \"redirect\": {\n" +
				"      \"notifyUrl\": \"http://localhost:8082/v1/payment/notify\",\n" +
				"      \"returnUrl\": \"http://localhost:8082/v1/payment/return\"\n" +
				"    },\n" +
				"    \"order\": {\n" +
				"        \"merchantOrderId\": \"string\",\n" +
				"        \"currency\": \"ZAR\",\n" +
				"        \"amount\": 856,\n" +
				"        \"transactionDate\": \"2014-04-06T18:30:00+02:00\"\n" +
				"    }\n" +
				"  }\n" +
				"}";
	}
}
