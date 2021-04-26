package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.MessageDTO;
import ru.itis.springbootdemo.models.Message;

public interface MessageDTOService {
    Message messageFromDTO(MessageDTO messageDTO);
}
