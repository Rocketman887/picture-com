package ru.itis.springbootdemo.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.interfacies.ImagePostDTOService;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;
import ru.itis.springbootdemo.services.interfacies.UsersService;


@Controller
@RequiredArgsConstructor
public class ImagePostController {

    private final ImagePostsService imagePostsService;
    private final ImagePostDTOService imagePostDTOService;
    private final UsersDTOService usersDTOService;
    private final UsersService usersService;


    @PreAuthorize("permitAll()")
    @GetMapping("/imagePosts/{id}")
    public String getImagePost(@PathVariable(value = "id") Long id, Model model,
                               @AuthenticationPrincipal UserDetailsImpl security) {
        ImagePostDTO imagePostDTO = imagePostDTOService.imagePostDTOFrom(imagePostsService.getImagePost(id));
        User owner = usersService.getUserById(imagePostDTO.getOwnerId());
        model.addAttribute("owner",usersDTOService.userToDto(owner));
        if (security != null) {
            model.addAttribute("user", usersDTOService.userToDto(security.getUser()));
        }
        model.addAttribute("imagePost", imagePostDTO);
        return "imagePost_page";
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/imagePosts/all")
    public String getAllImagePosts(Model model,
                                   @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)
                                           Pageable pageable
    ) {

        Page<ImagePost> page = imagePostsService.getAllImagePosts(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/imagePosts/all");
        return "imagePosts_page";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myImagePosts")
    public String getImagePostOwnedByUser(@AuthenticationPrincipal UserDetailsImpl security, Model model,
                                          @PageableDefault(sort = {"id"},
                                                  direction = Sort.Direction.DESC)
                                                  Pageable pageable) {
        Page<ImagePost> page = imagePostsService.getImagePostsOwnedByUser(security.getId(), pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/myImagePosts");
        return "imagePosts_page";
    }


}
