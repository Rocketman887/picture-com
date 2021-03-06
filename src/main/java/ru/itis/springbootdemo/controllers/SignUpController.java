package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.services.interfacies.MailService;
import ru.itis.springbootdemo.services.interfacies.SignUpService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    @Autowired
    private final SignUpService signUpService;

    @Autowired
    private final MailService mailService;

    @PermitAll
    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm",new UserForm());
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()) {
            Boolean isSuccess = signUpService.signUp(userForm);
            if(isSuccess){
                UserDTO user = new UserDTO();
                user.setId();
                return "redirect:/auth";
            }
            return "redirect:/signUp";
        }
    }
}
