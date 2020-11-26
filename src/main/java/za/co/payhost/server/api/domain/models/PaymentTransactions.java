package za.co.payhost.server.api.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
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

    @NotNull
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

    @NotNull
    @Column(name = "risk_indicator")
    private String riskIndicator;

    @NotNull
    @Column(name = "pay_request_id")
    private String payRequestId;

    @NotNull
    @Column(name = "result_code")
    private String resultCode;

    @NotNull
    @Column(name = "transaction_id")
    private String transactionId;

    @NotNull
    @Column(name = "payment_type_id")
    private String paymentTypeId;

    @NotNull
    @Column(name = "payment_type_detail")
    private String paymentTypeDetail;

    @NotNull
    @Column(name = "transaction_status_description")
    private String transactionStatusDescription;

    @NotNull
    @Column(name = "status_name")
    private String statusName;

    @NotNull
    @Column(name = "transaction_status_code")
    private String transactionStatusCode;

    @NotNull
    @Column(name = "result_description")
    private String resultDescription;

    @NotNull
    @Column(name = "acquirer_code")
    private String acquirerCode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getVaultId() {
        return vaultId;
    }

    public void setVaultId(String vaultId) {
        this.vaultId = vaultId;
    }

    public String getRiskIndicator() {
        return riskIndicator;
    }

    public void setRiskIndicator(String riskIndicator) {
        this.riskIndicator = riskIndicator;
    }

    public String getPayRequestId() {
        return payRequestId;
    }

    public void setPayRequestId(String payRequestId) {
        this.payRequestId = payRequestId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeDetail() {
        return paymentTypeDetail;
    }

    public void setPaymentTypeDetail(String paymentTypeDetail) {
        this.paymentTypeDetail = paymentTypeDetail;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(String transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public String getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(String acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
