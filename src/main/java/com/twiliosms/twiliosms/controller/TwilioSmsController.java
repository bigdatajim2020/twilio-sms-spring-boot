package com.twiliosms.twiliosms.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twiliosms.twiliosms.dto.SmsRequest;
import com.twiliosms.twiliosms.service.TwilioSmsSender;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TwilioSmsController {
    private final TwilioSmsSender twilioSmsSender;
    
    @PostMapping("/sms")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
    	twilioSmsSender.sendSms(smsRequest);
    }
}
