package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.services.interfacies.MailMessageCreator;

@Service
@RequiredArgsConstructor
public class MailMessageCreatorImpl implements MailMessageCreator {
    @Override
    public String createMailMessage(UserDTO userDTO, String basicAddress) {
            String message = String.format(
                    "Hello,"+userDTO.getName() +
                            "\n Welcome to picture.com. Please, visit next link:"+basicAddress,
                    userDTO.getName(),
                    userDTO.getCode()
            );

        return message;
    }
}
