package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.services.interfacies.ImagePostDTOService;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class EditImagePostController {
    private final ImagePostsService imagePostsService;
    private final ImagePostDTOService imagePostDTOService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/imagePosts/update/{id}")
    public String getUpdateImagePostPage(@PathVariable(value = "id") Long id, Model model) {
        ImagePostDTO imagePostDTO = imagePostDTOService.imagePostDTOFrom(imagePostsService.getImagePost(id));
        model.addAttribute("imagePost",imagePostDTO);
        return "updateImagePost_page";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts/delete/{id}")
    public String deleteImagePost(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        imagePostsService.deleteImagePost(id);
        redirectAttributes.addFlashAttribute("message","Your imagePost was successfully deleted! ");
        return "redirect:/imagePosts/all";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/imagePosts/update/{id}")
    public String updateImagePost(@PathVariable Long id, Model model,
                                  @Valid ImagePostForm imagePostForm,
                                  @RequestParam MultipartFile file) throws IOException {
        ImagePostDTO imagePostDTO = imagePostDTOService.imagePostDTOFrom(imagePostsService.getImagePost(id));
        model.addAttribute("imagePost",imagePostDTO);
        imagePostsService.updateImagePost(id, imagePostForm, file);
        return "redirect:/imagePosts/{id}";
    }


}
