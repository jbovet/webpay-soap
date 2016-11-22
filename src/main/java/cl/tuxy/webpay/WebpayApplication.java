package cl.tuxy.webpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cl.tuxy.webpay.*")
public class WebpayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebpayApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(WebpayApplication.class);
    }

}
