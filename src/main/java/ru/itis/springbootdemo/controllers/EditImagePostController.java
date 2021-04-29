package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class EditImagePostController {
    private final ImagePostsService imagePostsService;
    private final UsersDTOService usersDTOService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts/update/{id}")
    public ResponseEntity<?> deleteImagePost(@PathVariable("id") Long id){
        imagePostsService.deleteImagePost(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts/delete/{id}")
    public ResponseEntity<ImagePost> updateImagePost(@PathVariable("id") Long id, @Valid @RequestBody ImagePostForm imagePostForm) {
        return ResponseEntity.ok(imagePostsService.updateImagePost(id,imagePostForm));
    }

}
