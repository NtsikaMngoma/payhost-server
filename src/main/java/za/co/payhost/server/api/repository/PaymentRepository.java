package za.co.payhost.server.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.payhost.server.api.domain.models.PaymentTransactions;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransactions, Long>, JpaSpecificationExecutor<PaymentTransactions> {
    @Query("select id from PaymentTransactions ptr where ptr.id = :reference_id ")
    Optional<PaymentTransactions> retrieveByReferenceId(@Param("reference_id") String referenceId);

    @Query("select email from PaymentTransactions ptr where ptr.email = :email_address")
    Optional<PaymentTransactions> findByEmailAddress(@Param("email_address") String emailAddress);

    @Query("select lastName from PaymentTransactions ptr where ptr.lastName = :surname")
    Optional<PaymentTransactions> findByLastName(@Param("surname") String lastName);
}
