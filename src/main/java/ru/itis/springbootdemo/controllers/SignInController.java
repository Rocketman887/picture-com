package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;

@Controller
@RequiredArgsConstructor
public class SignInController {

    @PermitAll
    @GetMapping("/signIn")
    public String getSignInPage(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        return "signIn_page";
    }
}
