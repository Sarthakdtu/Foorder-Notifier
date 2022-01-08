package com.foordernotif.notifier.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = { "com.foorder.notifier*" })
@PropertySource("classpath:application.properties")
public class TwilioConfig {

    @Value("${ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${whatsAppSender}")
    private String whatsAppSender;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TwilioKeys getTwilioKeys(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        TwilioKeys twilioKeys = new TwilioKeys();
        twilioKeys.setWhatsAppSender(whatsAppSender);
        return twilioKeys;
    }
}
