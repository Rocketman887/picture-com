package ru.itis.springbootdemo.services.interfacies;


public interface SenderService {
    void sendMail(String emailTo,String subject, String message);
}
