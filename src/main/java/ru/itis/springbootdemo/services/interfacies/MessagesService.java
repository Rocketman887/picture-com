package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.MessageDTO;

public interface MessagesService {
    void saveMessage(MessageDTO messageDTO);
}
