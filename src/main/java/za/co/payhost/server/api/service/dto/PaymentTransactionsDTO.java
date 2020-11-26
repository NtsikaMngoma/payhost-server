package za.co.payhost.server.api.service.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentTransactionsDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @JsonProperty("first_name")
    private String firstName;
    @NotNull
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("telephone_number")
    private String telephoneNumber;
    @NotNull
    @JsonProperty("mobile_number")
    private String mobileNumber;
    @NotNull
    private String email;
    @NotNull
    @JsonProperty("card_number")
    private String cardNumber;
    @NotNull
    @JsonProperty("card_expiry_date")
    private String cardExpiryDate;
    @NotNull
    @JsonProperty("card_cvv")
    private String cardCVV;
    @NotNull
    @JsonProperty("reference_id")
    private String referenceId;
    @NotNull
    private String currency;
    @NotNull
    private BigDecimal amount;
    @NotNull
    @JsonProperty("transaction_date")
    private Date transactionDate;

    // Paygate:
    @JsonProperty("auth_code")
    private String authCode;

    @JsonProperty("vault_id")
    private String vaultId;

    @NotNull
    @JsonProperty("risk_indicator")
    private String riskIndicator;

    @NotNull
    @JsonProperty("pay_request_id")
    private String payRequestId;

    @NotNull
    @JsonProperty("result_code")
    private String resultCode;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("payment_type_id")
    private String paymentTypeId;

    @JsonProperty("payment_type_detail")
    private String paymentTypeDetail;

    @NotNull
    @JsonProperty("transaction_status_description")
    private String transactionStatusDescription;

    @JsonProperty("status_name")
    private String statusName;

    @JsonProperty("transaction_status_code")
    private String transactionStatusCode;

    @JsonProperty("result_description")
    private String resultDescription;

    @JsonProperty("acquirer_code")
    private String acquirerCode;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
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
}
