package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ProfileNameEditForm;
import ru.itis.springbootdemo.dtos.forms.ProfilePasswordEditForm;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ProfileService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import javax.validation.Valid;
import java.io.IOException;

@PreAuthorize("isAuthenticated()")
@Controller
@RequiredArgsConstructor
public class EditProfileController {

    private final UsersService usersService;
    private final ProfileService profileService;
    private final UsersDTOService usersDTOService;


    @GetMapping("/editProfile")
    public String getEditProfilePage(@AuthenticationPrincipal UserDetailsImpl security,
                                     Model model) {
        UserDTO userDTO = usersDTOService.userToDto(security.getUser());
        model.addAttribute("userName", userDTO.getName());
        model.addAttribute("imagePath", userDTO.getImagePath());
        model.addAttribute("nameEditForm",new ProfileNameEditForm());
        model.addAttribute("passwordEditForm",new ProfilePasswordEditForm());

        return "editProfile_page";
    }

    @PostMapping("/editProfile/name")
    public String editProfileName(@Valid ProfileNameEditForm nameEditForm,
                                  @AuthenticationPrincipal UserDetailsImpl security,
                                  Model model) {
        boolean isExist = usersService.existByName(nameEditForm.getName());
        if (!isExist) {
            if (profileService.editName(nameEditForm,
                    usersDTOService.userToDto(security.getUser()))) {
                model.addAttribute("message", "profile successfully updated!");
            } else {
                model.addAttribute("message", "password is incorrect!");
            }
        }
        return "redirect:/editProfile";
    }

    @PostMapping("/editProfile/password")
    public String editProfilePassword(@Valid ProfilePasswordEditForm passwordEditForm,
                                      BindingResult bindingResult,
                                      @AuthenticationPrincipal UserDetailsImpl security,
                                      Model model) {
        if (!bindingResult.hasErrors()) {
            if (profileService.editPassword(passwordEditForm,
                    usersDTOService.userToDto(security.getUser()))) {
                model.addAttribute("message", "password successfully updated!");
            } else {
                model.addAttribute("message", "password is incorrect!");
            }
        }
        return "redirect:/editProfile";
    }
    @PostMapping("/editProfile/image")
    public String editImage(@AuthenticationPrincipal UserDetailsImpl security,
                            @RequestParam("file") MultipartFile file,
                            Model model) throws IOException {

        UserDTO userDTO = usersDTOService.userToDto(security.getUser());
        profileService.editImage(userDTO,file);
        model.addAttribute("message", "Your avatar was successfully updated!");
        return "redirect:/editProfile";
    }
}
