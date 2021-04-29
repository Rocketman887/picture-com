package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.SmsInfo;

public interface SmsService {
    String sendSms(String phone, String text);

    String checkSmsStatus(SmsInfo smsInfo);
}
