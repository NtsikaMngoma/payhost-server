package za.co.payhost.server.api.soapconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author Ntsika Mngoma
 *
 */
@Configuration
public class SoapConfig {
    
    @Value("${paygate.package}")
    private String payhostPackage;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySoapConfig() {
    	return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public Jaxb2Marshaller marshaller() {
    	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(payhostPackage);
        return marshaller;
    }
}
