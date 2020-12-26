package za.co.payhost.server.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import za.co.paygate.payhost.WebPaymentRequestType;

@Controller
public class WebPaymentController {

	@PostMapping("web-payment")
	public String makeWebPayment(@RequestBody WebPaymentRequestType webRequest) {
		return "paymentView";
	}
}
