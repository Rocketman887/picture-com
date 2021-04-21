package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dtos.forms.ImagePostSearchForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostsSearchService;


@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class ImageSearchController {

    private final ImagePostsSearchService imagePostsSearchService;

    @GetMapping("/search")
    public String getSearchPage(@AuthenticationPrincipal UserDetailsImpl security,
                                Model model){
        model.addAttribute("postSearchForm", new ImagePostSearchForm());
        return "search_page";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getImagePostsBySearchForm(@RequestBody ImagePostSearchForm searchForm) {
        Page<ImagePost> imagePosts = imagePostsSearchService.findAllBySearchForm(searchForm);
        return imagePosts.toList().toString();
    }
}
