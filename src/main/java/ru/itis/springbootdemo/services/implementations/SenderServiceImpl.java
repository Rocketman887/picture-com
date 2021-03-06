package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.services.interfacies.SenderService;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
public class SenderServiceImpl implements SenderService {
    @Value("${spring.mail.username}")
    private String senderName;

    @Autowired
    private final JavaMailSender mailSender;

    @Autowired
    private final ExecutorService executorService;

    @Override
    public void sendMessage(String subject, String mail, String html) {
        Runnable runnable = () -> {
            MimeMessagePreparator message = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());
                messageHelper.setFrom(senderName);
                messageHelper.setTo(mail);
                messageHelper.setSubject(subject);
                messageHelper.setText(html, true);
            };
            mailSender.send(message);
        };
        executorService.submit(runnable);
    }
}
