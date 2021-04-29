package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;

@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class ChatController {

    @GetMapping("/messages")
    public String getChatPage(Model model,
                              @AuthenticationPrincipal
                                      UserDetailsImpl security){
        model.addAttribute("id",security.getId());
        return "chat_page";
    }
}
