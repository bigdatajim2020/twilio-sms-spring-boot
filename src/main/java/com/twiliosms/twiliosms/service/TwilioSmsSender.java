package com.twiliosms.twiliosms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twiliosms.twiliosms.config.TwilioConfiguration;
import com.twiliosms.twiliosms.dto.SmsRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TwilioSmsSender {
	private final TwilioConfiguration twilioConfiguration;
	private final String phoneRegex="^(\\d{3}[- .]?){2}\\d{4}$"; //U.S/Canada phone pattern
	private final static Logger LOGGER=LoggerFactory.getLogger(TwilioSmsSender.class);
		
    public void sendSms(SmsRequest smsRequest) {
    	if (smsRequest.getPhoneNumber().matches(phoneRegex)) {
         //to, from, body    	 
    	 Message.creator(
    			 new PhoneNumber(smsRequest.getPhoneNumber()),
    			 new PhoneNumber(twilioConfiguration.getTrialNumber()),
    			 smsRequest.getMessage()
    			 ).create();
    	 LOGGER.info("Send SMS: {} "+ smsRequest);
    	} else {
    		throw new IllegalArgumentException(
    				"You entered invalid phone number: "+smsRequest.getPhoneNumber());
    	}
    }
}
