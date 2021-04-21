package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.UserDTO;

public interface MailMessageCreator {
    String createMailMessage(UserDTO userDTO, String basicAddress);
}
