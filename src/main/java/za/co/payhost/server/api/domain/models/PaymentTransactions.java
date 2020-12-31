package za.co.payhost.server.api.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Ntsika Mngoma
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_transactions", uniqueConstraints = @UniqueConstraint(columnNames = "reference_id"))
public class PaymentTransactions implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "id_number", nullable = false, length = 13)
    private String idNumber;

    @Column(name = "telephone_number", length = 13)
    private String telephoneNumber;

    @Column(name = "mobileNumber", nullable = false, length = 13)
    private String mobileNumber;

    @NotNull
    @Column(name = "email_address", nullable = false, length = 50)
    private String email;

    @Column(name = "reference_id", nullable = false)
    private String referenceId;

    @NotNull
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @NotNull
    @Column(precision = 21, scale = 2, nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    // PayGate Statuses:

    @Column(name = "auth_code")
    private String authCode;

    @Column(name = "vault_id")
    private String vaultId;

    @Column(name = "risk_indicator")
    private String riskIndicator;

    @Column(name = "pay_request_id")
    private String payRequestId;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "payment_type_id")
    private String paymentTypeId;

    @Column(name = "payment_type_detail")
    private String paymentTypeDetail;

    @Column(name = "transaction_status_description")
    private String transactionStatusDescription;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "transaction_status_code")
    private String transactionStatusCode;

    @Column(name = "result_description")
    private String resultDescription;

    @Column(name = "acquirer_code")
    private String acquirerCode;
}
