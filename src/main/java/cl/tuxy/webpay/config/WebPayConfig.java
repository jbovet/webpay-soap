package cl.tuxy.webpay.config;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.configuration.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;


/**
 * Created by josebovet on 11/21/16.
 */
@org.springframework.context.annotation.Configuration
public class WebPayConfig {

    @Value("${transbank.webpay.commerceCode}")
    private String comerceCode;

    @Value("${transbank.webpay.env}")
    private String env;

    @Value("${transbank.webpay.cert.private}")
    private Resource privateKey;

    @Value("${transbank.webpay.cert.public}")
    private Resource publicKey;

    @Value("${transbank.webpay.cert.webpay}")
    private Resource cert;

    @Bean
    Configuration configuration() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setCommerceCode(comerceCode);
        configuration.setPrivateKey(new String(FileCopyUtils.copyToByteArray(privateKey.getInputStream())));
        configuration.setPublicCert(new String(FileCopyUtils.copyToByteArray(publicKey.getInputStream())));
        configuration.setWebpayCert(new String(FileCopyUtils.copyToByteArray(cert.getInputStream())));
        configuration.setEnvironment(env);
        return configuration;

    }

    @Bean
    public Webpay webpay() throws IOException {
        return new Webpay(configuration());

    }

}
