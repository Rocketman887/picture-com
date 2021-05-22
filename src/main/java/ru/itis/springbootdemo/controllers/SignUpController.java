package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.services.interfacies.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;
    private final ConfirmationService confirmationService;

    @PermitAll
    @GetMapping("/signUp")
    public String getSignUpPage(@RequestParam(value = "error", required = false) String error,
                                Model model,
                                Authentication authentication) {
        if(authentication==null) {
            model.addAttribute("userForm", new UserForm());
            model.addAttribute("error", error);
            return "signUp_page";
        }
        else{
            return "redirect:/";
        }
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()) {
            boolean isSuccess = signUpService.signUp(userForm);
            if(isSuccess){
                signUpService.signUp(userForm);
                return "redirect:/signIn";
            }
            else {
                model.addAttribute("message","user with such email or" +
                        " with such name already exists");
                return "signUp_page";
            }
        }
        else {
            model.addAttribute("userForm",userForm);
            return "signUp_page";
        }
    }
        @GetMapping("/activate/{code}")
        public String activate(Model model, @PathVariable String code,
                               RedirectAttributes redirectAttributes){
            boolean isActivated = confirmationService.activateUser(code);

            if (!isActivated) {
                redirectAttributes.addAttribute("message", "User successfully activated");
            } else {
                redirectAttributes.addAttribute("message", "Activation code is not found!");
            }
            return "redirect:/signIn";
        }
}
