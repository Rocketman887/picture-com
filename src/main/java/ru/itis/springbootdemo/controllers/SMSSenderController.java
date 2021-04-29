package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootdemo.dtos.dtos.SmsInfo;

import javax.annotation.security.PermitAll;

@Controller
@RequiredArgsConstructor
public class SMSSenderController {

        private final SMSSenderController smsSender;
        @PermitAll
        @GetMapping("/sendSms")
        public String sendSmsMessage(@RequestParam String phone, @RequestParam String text) {
            return smsSender.sendSmsMessage(phone, text);
        }

        @PermitAll
        @GetMapping("/checkStatus")
        public String checkSmsStatus(@ModelAttribute SmsInfo smsInfo){
            return smsSender.checkSmsStatus(smsInfo);
        }
}

