package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class ProfileController {

    private final UsersDTOService usersDTOService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl security,
                                 Model model) {
        UserDTO userDTO = usersDTOService.userToDto(security.getUser());
        model.addAttribute("userName", userDTO.getName());
        model.addAttribute("imagePath", userDTO.getImagePath());
        return "profile_page";
    }

}
