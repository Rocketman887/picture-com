package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.services.interfacies.SenderService;
import ru.itis.springbootdemo.services.interfacies.SignUpService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;
    private final SenderService senderService;
    private final UsersDTOService usersDTOService;
    private final UsersService usersService;

    @PermitAll
    @GetMapping("/signUp")
    public String getSignUpPage(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        model.addAttribute("userForm",new UserForm());
        model.addAttribute("error",error);
        return "signUp_page";
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
        public String activate(Model model, @PathVariable String code){
            boolean isActivated = usersService.activateUser(code);

            if (isActivated) {
                model.addAttribute("message", "User successfully activated");
            } else {
                model.addAttribute("message", "Activation code is not found!");
            }

            return "redirect:/signIn";
        }
}
