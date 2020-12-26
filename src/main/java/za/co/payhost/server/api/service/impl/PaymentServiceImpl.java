package za.co.payhost.server.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.payhost.server.api.domain.models.PaymentTransactions;
import za.co.payhost.server.api.repository.PaymentRepository;
import za.co.payhost.server.api.service.PaymentService;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;
import za.co.payhost.server.api.service.mapper.PaymentTransactionsMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final PaymentRepository paymentRepository;
    private final PaymentTransactionsMapper mapper;

    @Autowired
    public PaymentServiceImpl(PaymentTransactionsMapper mapper, PaymentRepository paymentRepository) {
        this.mapper = mapper;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentTransactionsDTO save(PaymentTransactionsDTO paymentTransactionsDTO) {
        log.debug("Request to save paymentTransaction : {}", paymentTransactionsDTO);
        PaymentTransactions transaction = mapper.toEntity(paymentTransactionsDTO);
        transaction = paymentRepository.save(transaction);
        return mapper.toDto(transaction);
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
}
