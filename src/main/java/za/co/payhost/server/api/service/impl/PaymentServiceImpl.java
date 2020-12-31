package za.co.payhost.server.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.paygate.payhost.CurrencyType;
import za.co.paygate.payhost.PersonType;
import za.co.paygate.payhost.RedirectRequestType;
import za.co.paygate.payhost.SinglePaymentRequest;
import za.co.paygate.payhost.SinglePaymentResponse;
import za.co.paygate.payhost.StatusType;
import za.co.payhost.server.api.domain.models.PaymentTransactions;
import za.co.payhost.server.api.repository.PaymentRepository;
import za.co.payhost.server.api.service.PaymentService;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;
import za.co.payhost.server.api.service.mapper.PaymentTransactionsMapper;
import za.co.payhost.server.api.utils.PaymentFailedException;
import za.co.payhost.server.api.utils.UniqueIdGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Value("${paygate.id}")
	public String payGateId;

	@Value("${paygate.password}")
	public String payGatePassword;
	
	@Value("${application.returnUrl}")
	public String returnUrl;
	
	@Value("${application.notifyUrl}")
	public String notifyUrl;
		
    private final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final PaymentRepository paymentRepository;
    private final PaymentTransactionsMapper mapper;
    public SinglePaymentRequest singlePaymentRequest;

    @Autowired
    public PaymentServiceImpl(PaymentTransactionsMapper mapper, PaymentRepository paymentRepository) {
        this.mapper = mapper;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentTransactionsDTO> listAll() {
        log.debug("Request to get all paymentTransactions");
        return paymentRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionsDTO> listOne(Long id) {
        log.debug("Request to get one payment transaction : {}", id);
        return paymentRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<PaymentTransactionsDTO> retrieveByReferenceId(String referenceId) {
        log.debug("Request to get by ref_id : {}", referenceId);
        return paymentRepository.retrieveByReferenceId(referenceId).map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionsDTO> listBySurname(String surname) {
        log.debug("Request to get one payment transaction by surname : {}", surname);
        return paymentRepository.findByLastName(surname).map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionsDTO> listByEmailAddress(String emailAddress) {
        log.debug("Request to get one payment transaction by mail : {}", emailAddress);
        return paymentRepository.findByEmailAddress(emailAddress).map(mapper::toDto);
    }

	@Override
	public void cardValidator(String cardNumber) {
		// TODO Auto-generated method stub
		log.debug("Card Number validation for cardNumber: {}", cardNumber);
		int[] ints = new int[cardNumber.length()];
		for (int i = 0; i < cardNumber.length(); i++) {
			ints[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
			log.info("%s is a valid credit card number", cardNumber);
		} else {
			log.info("%s an invalid credit card number", cardNumber);
		}
	}
	
	@Override
    public PaymentTransactionsDTO save(PaymentTransactionsDTO paymentTransactionsDTO, SinglePaymentRequest request) 
    		throws IOException, DatatypeConfigurationException {
		// TODO Auto-generated method stub
        log.debug("Request to save paymentTransaction : {}", paymentTransactionsDTO);
        PaymentTransactions transaction = mapper.toEntity(paymentTransactionsDTO);
        
        // Customer Info
        PersonType customerInfo = request.getCardPaymentRequest().getCustomer();
        String firstName = customerInfo.getFirstName();
        String idNumber = customerInfo.getIdNumber();
        String lastName = customerInfo.getLastName();
        String title = customerInfo.getTitle();

        List<String> emailAddressList = customerInfo.getEmail();
        for (String emailString : emailAddressList) {
	        transaction.setEmail(emailString);
		}
        
        int amount = request.getCardPaymentRequest().getOrder().getAmount();
        
        // Order from request        
        List<String> mobileNumberString = customerInfo.getMobile();
        for (String mobileNumber : mobileNumberString) {
	        transaction.setMobileNumber(mobileNumber);
		}
        transaction.setFirstName(firstName);
        transaction.setLastName(lastName);
        transaction.setTitle(title);
        transaction.setIdNumber(idNumber);
        
        BigDecimal finalAmount = BigDecimal.valueOf(amount).setScale(2);
        transaction.setAmount(finalAmount);
        
        // Order
        UniqueIdGenerator guid = new UniqueIdGenerator(); 
        // Merchant Order Id Append from POJO to JSON
        String generatedGuid = guid.generateAlphaNumberic();
        request.getCardPaymentRequest().getOrder().setMerchantOrderId(generatedGuid);
        transaction.setReferenceId(generatedGuid);
        transaction.setTransactionDate(transactionDateConversion());
        // Persist Response
        transaction = paymentRepository.save(transaction);
        return mapper.toDto(transaction);
    }

	@Override
	public SinglePaymentResponse saveTransactionResults(SinglePaymentResponse response, PaymentTransactionsDTO transactions) {
		// TODO Auto-generated method stub
		StatusType results = response.getCardPaymentResponse().getStatus();	
		try {
			if (transactions == null) {
				throw new PaymentFailedException("Your payment could be processed");
			}
			transactions.setTransactionStatusDescription(results.getTransactionStatusDescription());
			transactions.setResultCode(results.getResultCode());
			transactions.setRiskIndicator(results.getRiskIndicator());
			transactions.setPayRequestId(results.getPayRequestId());
			transactions.setResultCode(results.getResultCode());
			transactions.setTransactionStatusCode(results.getTransactionStatusCode());
			transactions.setPaymentTypeId(results.getPaymentType().getMethod().name().toString());
			transactions.setPaymentTypeDetail(results.getPaymentType().getDetail());
			transactions.setAcquirerCode(results.getAcquirerCode());
			transactions.setCurrency(results.getCurrency().toString());
			transactions.setResultDescription(results.getResultDescription());
			transactions.setStatusName(results.getStatusName().toString());
			transactions.setTransactionId(results.getTransactionId());
			transactions.setAuthCode(results.getAuthCode());
		} catch (PaymentFailedException e) {
			// TODO: handle exception
			throw new PaymentFailedException("Your payment could be processed");
		}
		return response;
	}

	@Override
	public void appendRequests(SinglePaymentRequest request) {
		// TODO Auto-generated method stub
		request.getCardPaymentRequest().getAccount().setPayGateId(payGateId);
		request.getCardPaymentRequest().getAccount().setPassword(payGatePassword);
		request.getCardPaymentRequest().setBudgetPeriod("0");
        RedirectRequestType redirect = request.getCardPaymentRequest().getRedirect();
        redirect.setNotifyUrl(notifyUrl);
        redirect.setReturnUrl(returnUrl);
        // Set Default Currency
        request.getCardPaymentRequest().getOrder().setCurrency(CurrencyType.ZAR);
        // Amount 
        request.getCardPaymentRequest().getOrder().setAmount(5);
	}

	@Override
	public LocalDateTime transactionDateConversion() throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		 LocalDateTime transactionDate = LocalDateTime.now();

		 //Creating ZonedDateTime instance
		 ZonedDateTime zoneDateTime = 
		 ZonedDateTime.of(transactionDate, ZoneId.systemDefault());
	
		 //Creating GregorianCalendar instance
		 GregorianCalendar gregorianCalendar = 
		 GregorianCalendar.from(zoneDateTime);
	
		 //Creating XMLGregorianCalendar instance
		 XMLGregorianCalendar xmlGregorianCalendar =
		 DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		 return transactionDate;
	}
	
	public SinglePaymentRequest retrieveRequest() {
		return singlePaymentRequest;
	}
}
