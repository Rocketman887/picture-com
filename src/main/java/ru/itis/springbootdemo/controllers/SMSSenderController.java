package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootdemo.dtos.dtos.SmsInfo;
import ru.itis.springbootdemo.services.interfacies.SmsService;

import javax.annotation.security.PermitAll;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class SMSSenderController {

        private final SmsService smsSender;

        @GetMapping("/sms")
        public String getSmsMessage() {
                return "sms";
        }

        @PostMapping("/sendSms")
        public String sendSmsMessage(@RequestParam String number, @RequestParam String text) {
            smsSender.sendSms(number, text);
            return "redirect:/sms";
        }

        @GetMapping("/checkStatus")
        public String checkSmsStatus(@ModelAttribute SmsInfo smsInfo){
            return smsSender.checkSmsStatus(smsInfo);
        }
}

