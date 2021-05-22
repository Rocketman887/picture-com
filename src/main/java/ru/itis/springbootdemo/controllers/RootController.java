package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {

    @PermitAll
    @GetMapping
    public String getRoot() {
        return "redirect:/imagePosts/all";
    }
}
