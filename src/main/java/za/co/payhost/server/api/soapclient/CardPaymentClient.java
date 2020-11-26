package za.co.payhost.server.api.soapclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import za.co.paygate.payhost.SinglePaymentRequest;
import za.co.paygate.payhost.SinglePaymentResponse;
import za.co.payhost.server.api.service.dto.PaymentTransactionsDTO;

/**
 * @author Ntsika Mngoma
 *
 */
@Service
public class CardPaymentClient {
	
	@Value("${paygate.endpoint}")
	private String endpoint;
	
	@Value("${paygate.namespace.uri}")
	private String namespace;
	
	@Autowired
	private Jaxb2Marshaller marshaller;

	public SinglePaymentResponse makePayment(SinglePaymentRequest request) {
		WebServiceTemplate template = new WebServiceTemplate(marshaller);
		return (SinglePaymentResponse) template.marshalSendAndReceive(
				endpoint, request, 
				new SoapActionCallback(namespace));
	}
}
