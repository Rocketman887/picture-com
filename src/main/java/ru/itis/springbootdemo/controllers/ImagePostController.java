package ru.itis.springbootdemo.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class ImagePostController {

    private final ImagePostsService imagePostsService;
    private final UsersDTOService usersDTOService;

    @PreAuthorize("permitAll()")
    @GetMapping("/imagePosts/{id}")
    public ResponseEntity<ImagePost> getImagePost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(imagePostsService.getImagePost(id));
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/imagePosts")
    public ResponseEntity<Page<ImagePost>> getAllImagePosts(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(imagePostsService.getAllImagePosts(pageable));
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts")
    public ResponseEntity<ImagePost> createImagePost(@Valid @RequestBody ImagePostForm imagePostForm,
                                                     @AuthenticationPrincipal UserDetailsImpl security) {
        return ResponseEntity.ok(imagePostsService.createImagePost(imagePostForm,
                usersDTOService.userToDto(security.getUser())));
    }

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
