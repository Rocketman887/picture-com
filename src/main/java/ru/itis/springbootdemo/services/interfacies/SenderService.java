package ru.itis.springbootdemo.services.interfacies;

public interface SenderService {
        void sendMessage(String subject, String email, String html);
}
