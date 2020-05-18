package za.co.payhost.server.api.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.paygate.payhost.SinglePaymentRequest;
import za.co.paygate.payhost.SinglePaymentResponse;
import za.co.payhost.server.api.soapclient.CardPaymentClient;

/**
 * @author Ntsika Mngoma
 *
 */
@RestController
@RequestMapping("pay-with")
public class CardPaymentResource {
	
	@Autowired
	private CardPaymentClient cardPaymentClient;
	
	/**
	 * @return POST String
	 */
	@PostMapping(value = "example", produces = { MediaType.TEXT_XML_VALUE })
	public ResponseEntity<String> postExample() {
		return ResponseEntity.ok(form());
	}
	
	/**
	 * @param request POST 
	 * @return
	 */
	@PostMapping(value = "card")
	@ResponseBody
    public ResponseEntity<SinglePaymentResponse> processPayment(@RequestBody SinglePaymentRequest request){
    	return ResponseEntity.ok(cardPaymentClient.makePayment(request));
    }
	
	public String form() {
		return "<ns1:SinglePaymentRequest xmlns:ns1=\"http://www.paygate.co.za/PayHOST\">\r\n" + 
			   		"    <ns1:CardPaymentRequest>\r\n" + 
			   		"        <ns1:Account>\r\n" + 
			   		"            <ns1:PayGateId>10011064270</ns1:PayGateId>\r\n" + 
			   		"            <ns1:Password>test</ns1:Password>\r\n" + 
			   		"        </ns1:Account>\r\n" + 
			   		"        <ns1:Customer>\r\n" + 
			   		"            <ns1:Title>Mrs</ns1:Title>\r\n" + 
			   		"            <ns1:FirstName>Daniella</ns1:FirstName>\r\n" + 
			   		"            <ns1:LastName>Soap</ns1:LastName>\r\n" + 
			   		"            <ns1:Email>dsoap@example.co.za</ns1:Email>\r\n" + 
			   		"        </ns1:Customer>\r\n" + 
			   		"        <ns1:CardNumber>4000000000000002</ns1:CardNumber>\r\n" + 
			   		"        <ns1:CardExpiryDate>122020</ns1:CardExpiryDate>\r\n" + 
			   		"        <ns1:CVV>999</ns1:CVV>\r\n" + 
			   		"        <ns1:BudgetPeriod>0</ns1:BudgetPeriod>\r\n" + 
			   		"        <ns1:Redirect>\r\n" + 
			   		"            <ns1:NotifyUrl>http://localhost:8082/v1/payment/notify</ns1:NotifyUrl>\r\n" + 
			   		"            <ns1:ReturnUrl>http://localhost:8082/v1/payment/return</ns1:ReturnUrl>\r\n" + 
			   		"        </ns1:Redirect>\r\n" + 
			   		"        <ns1:Order>\r\n" + 
			   		"            <ns1:MerchantOrderId>order-1234</ns1:MerchantOrderId>\r\n" + 
			   		"            <ns1:Currency>ZAR</ns1:Currency>\r\n" + 
			   		"            <ns1:Amount>1000</ns1:Amount>\r\n" + 
			   		"            <ns1:TransactionDate>2014-04-06T18:30:00+02:00</ns1:TransactionDate>\r\n" + 
			   		"        </ns1:Order>\r\n" + 
			   		"    </ns1:CardPaymentRequest>\r\n" + 
			   		"</ns1:SinglePaymentRequest>";
	}
	
}
