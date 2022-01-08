package com.foordernotif.notifier.service;

import com.foordernotif.notifier.config.TwilioConfig;
import com.foordernotif.notifier.config.TwilioKeys;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppNotifier {
    private static final Logger logger = LoggerFactory.getLogger(WhatsAppNotifier.class.getName());

    public WhatsAppNotifier(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TwilioConfig.class);
        TwilioKeys twilioKeys = context.getBean(TwilioKeys.class);
    }

    public void notify(String number, String msg) {
        PhoneNumber sender = new PhoneNumber("whatsapp:+14155238886");
        PhoneNumber receiver = new PhoneNumber("whatsapp:"+number);
        Message message = Message.creator(
                        receiver,
                        sender,
                        msg)
                .create();
        logger.info("Message sent to " + receiver + " with id: " + message.getSid());
    }
}
