package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class CreateImagePostController {

    private final ImagePostsService imagePostsService;
    private final UsersDTOService usersDTOService;

    @GetMapping("/imagePosts/create")
    public String getImagePost() {
        return "createImagePost_page";
    }

    @PostMapping("/imagePosts/create")
    public String createImagePost(@Valid ImagePostForm imagePostForm,
                                  @AuthenticationPrincipal UserDetailsImpl security,
                                  @RequestParam MultipartFile file) throws IOException {
        imagePostsService.createImagePost(imagePostForm,usersDTOService.userToDto(security.getUser()),file);
        return "createImagePost_page";
    }
}
