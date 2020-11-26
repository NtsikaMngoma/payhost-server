package za.co.payhost.server.api.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import za.co.paygate.payhost.*;
import za.co.payhost.server.api.service.PaymentService;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;
import za.co.payhost.server.api.soapclient.CardPaymentClient;
import za.co.payhost.server.api.utils.HeaderUtil;
import za.co.payhost.server.api.utils.ResponseUtil;
import za.co.payhost.server.api.web.rest.exceptions.BadRequestAlertException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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

	@Value("${paygate.id}")
	public String payGateId;

	@Value("${paygate.password}")
	public String payGatePassword;
	@Value("${paygate.endpoint}")
	public String payGateUrl;

	private final CardPaymentClient cardPaymentClient;
	private final PaymentService paymentService;

	@Autowired
	public CardPaymentResource(CardPaymentClient cardPaymentClient, PaymentService paymentService) {
		this.cardPaymentClient = cardPaymentClient;
		this.paymentService = paymentService;
	}

	@GetMapping(value = "/example", produces = "application/json")
	public ResponseEntity<String> GetCall() {
		return ResponseEntity.ok(form());
	}
	
	/**
	 * @param request POST 
	 * @return cardPaymentResponse
	 */
	@PostMapping(value = "/make-call", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SinglePaymentResponse> processPayment(@RequestBody SinglePaymentRequest request) {
		return ResponseEntity.ok(cardPaymentClient.makePayment(request));
    }

	/**
	 * {@code POST /transact} : Create a new transaction.
	 * @param transaction the transaction to create
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operation, or with status {@code 400 (Bad Request)} if the transaction already has an ID.
	 * @throws URISyntaxException if the Location URI syntax is not correct.
	 */
    @PostMapping(value = "/card-payment", produces = "application/json")
	public ResponseEntity<PaymentTransactionsDTO> makePaymentTransaction(@Valid @RequestBody PaymentTransactionsDTO transaction) throws URISyntaxException, IOException {
		log.debug("REST request to save transaction : {}", transaction);
		if (transaction.getId() != null) {
			throw new BadRequestAlertException("A new transaction cannot already have an ID", ENTITY_NAME, "idexists");
		}
		PaymentTransactionsDTO transactionResults = paymentService.save(transaction);
		return ResponseEntity
				.created(new URI("/pay-with/transaction/" + transactionResults.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, transactionResults.getId().toString()))
				.body(transactionResults);
	}

	/**
	 * {@code PUT  /transact} : Updates an existing bankAccount.
	 *
	 * @param transaction the transaction to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transaction,
	 * or with status {@code 400 (Bad Request)} if the transaction is not valid,
	 * or with status {@code 500 (Internal Server Error)} if the transaction couldn't be updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping(value = "/card-payment")
	public ResponseEntity<PaymentTransactionsDTO> updateTransactions(@Valid @RequestBody PaymentTransactionsDTO transaction) throws URISyntaxException, IOException {
    	log.debug("REST request to update transaction : {}", transaction);
    	if (transaction.getId() == null) {
    		throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
    	PaymentTransactionsDTO paymentTransaction = paymentService.save(transaction);
    	return ResponseEntity
				.ok()
				.headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, transaction.getId().toString()))
				.body(paymentTransaction);
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
