package ru.itis.springbootdemo.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.springbootdemo.dtos.forms.ImagePostSearchForm;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostsSearchService;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
@PermitAll
public class ImagePostSearchController {

    private final ImagePostsSearchService imagePostsSearchService;
    @GetMapping("/search")
    public String getSearchPage(){
        return "search_page";
    }

    @GetMapping("/searchByTitle")
    public String getImagePostsByTitle(String title, Model model,
                                       @PageableDefault(sort = {"id"},
            direction = Sort.Direction.DESC)
            Pageable pageable) {
        Page<ImagePost> page = imagePostsSearchService.findByTitle(title,pageable);
        model.addAttribute("page",page);
        model.addAttribute("url","/searchByTitle");
        return "imagePosts_page";
    }
    @GetMapping("/searchByTag")
    public String getImagePostsByTag(String tag, Model model,
                                     @PageableDefault(sort = {"id"},
            direction = Sort.Direction.DESC)
            Pageable pageable){
        Page<ImagePost> page = imagePostsSearchService.findByTag(tag,pageable);
        model.addAttribute("page",page);
        model.addAttribute("url","/searchByTag");
        return "imagePosts_page";
    }

    @GetMapping("/searchByType")
    public String getImagePostsByType(String type, Model model,
                                      @PageableDefault(sort = {"id"},
            direction = Sort.Direction.DESC)
            Pageable pageable){
        Page<ImagePost> page = imagePostsSearchService.findByType(type,pageable);
        model.addAttribute("page",page);
        model.addAttribute("url","/searchByType");
        return "imagePosts_page";
    }
}
