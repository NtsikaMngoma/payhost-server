package za.co.payhost.server.api.service;

import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    /**
     * Save a paymentTransaction.
     *
     * @param paymentTransactionsDTO the entity to save
     * @return the persisted entity
     */
    PaymentTransactionsDTO save(PaymentTransactionsDTO paymentTransactionsDTO) throws IOException;

    /**
     * Get all the paymentTransactions.
     *
     * @return the list of paymentTransactions
     */
    List<PaymentTransactionsDTO> listAll();


    /**
     * Get the 'id' paymentTransaction.
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PaymentTransactionsDTO> listOne(Long id);

    /**
     * Get the 'reference_id' paymentTransaction.
     * @param referenceId the referenceId
     * @return the entity
     */
    Optional<PaymentTransactionsDTO> retrieveByReferenceId(String referenceId);
    /**
     * Get the 'surname' paymentTransaction.
     * @param surname the surname/last_name
     * @return the entity
     */
    Optional<PaymentTransactionsDTO> listBySurname(String surname);

    /**
     * Get the 'emailAddress' paymentTransaction.
     * @param emailAddress the emailAddress
     * @return the entity
     */
    Optional<PaymentTransactionsDTO> listByEmailAddress(String emailAddress);

    /**
     * Delete the 'id' paymentTransaction.
     *
     * @param id the id of the entity
     */
    void cardValidator(String cardNumber);
}
