package za.co.payhost.server.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PayhostServerApplication {
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(PayhostServerApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(PayhostServerApplication.class, args);
	}
}
