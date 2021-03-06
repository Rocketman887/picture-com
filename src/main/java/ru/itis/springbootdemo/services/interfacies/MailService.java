package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.UserDTO;

public interface MailService {
    void sendMail(UserDTO user);
}
