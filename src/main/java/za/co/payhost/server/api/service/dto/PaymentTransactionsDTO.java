package za.co.payhost.server.api.service.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ntsika Mngoma - 27/12/2020
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @NotNull
    @JsonProperty("id_number")
    private String idNumber;

	@JsonProperty("telephone_number")
    private String telephoneNumber;
    @NotNull
    @JsonProperty("mobile_number")
    private String mobileNumber;
    @NotNull
    private String email;
    @NotNull
    @JsonProperty("reference_id")
    private String referenceId;
    @NotNull
    private String currency;
    @NotNull
    private BigDecimal amount;
    
    @NotNull
    @JsonProperty("transaction_date")
    private LocalDateTime transactionDate;

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
}
