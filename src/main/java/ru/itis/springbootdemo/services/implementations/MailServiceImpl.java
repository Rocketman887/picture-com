package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.services.interfacies.MailService;
import ru.itis.springbootdemo.services.interfacies.SenderService;
import ru.itis.springbootdemo.services.interfacies.TemplateProcessor;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    @Value("${server.basic.address}")
    private final String serverBasicAddress;

    @Autowired
    private final SenderService senderService;

    @Autowired
    private final TemplateProcessor templateProcessor;

    @Override
    public void sendMail(UserDTO user) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", user.getUsername());
        parameters.put("link", serverBasicAddress + "confirm/" + user.getCode());
        sendMail(parameters, "email.ftlh", user.getEmail(), "Confirm your registration");
    }


    private void sendMail(Map<String, String> parameters, String template, String email, String subject) {
        String html = templateProcessor.getProcessedTemplate(parameters, template);
        senderService.sendMessage(subject, email, html);
    }
}
