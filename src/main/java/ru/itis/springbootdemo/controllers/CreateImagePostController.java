package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateImagePostController {

    private final ImagePostsService imagePostsService;
    private final UsersDTOService usersDTOService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts/create")
    public ResponseEntity<ImagePost> createImagePost(@Valid @RequestBody ImagePostForm imagePostForm,
                                                     @AuthenticationPrincipal UserDetailsImpl security) {
        return ResponseEntity.ok(imagePostsService.createImagePost(imagePostForm,
                usersDTOService.userToDto(security.getUser())));
    }
}
