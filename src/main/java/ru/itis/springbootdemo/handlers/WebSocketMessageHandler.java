package ru.itis.springbootdemo.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.springbootdemo.dtos.dtos.MessageDTO;
import ru.itis.springbootdemo.repositories.MessagesRepository;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketMessageHandler extends TextWebSocketHandler {

    private ObjectMapper objectMapper;

    private MessagesRepository messagesRepository;

    private static final Map<String, WebSocketSession> sessions = new HashMap<>();


        @Override
        public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
            String messageText = (String) message.getPayload();
            MessageDTO messageFromJson = objectMapper.readValue(messageText,MessageDTO.class);

            if (!sessions.containsKey(messageFromJson.getSender())) {
                sessions.put(messageFromJson.getSender(),session);
            }
            for (WebSocketSession currentSession : sessions.values()) {
                currentSession.sendMessage(message);
            }
        }

}