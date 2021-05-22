package ru.itis.springbootdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.springbootdemo.services.interfacies.AdminService;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final AdminService adminService;
    private final ImagePostsService imagePostsService;

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @PostMapping("/ban")
    public String banUserById(Long id,RedirectAttributes redirectAttributes){
        adminService.banUserById(id);
        redirectAttributes.addFlashAttribute("message","User is banned!");
        return "redirect:/admin";
    }

    @PostMapping("/banAll")
    public String banAll(RedirectAttributes redirectAttributes){
        adminService.banAllUsers();
        redirectAttributes.addFlashAttribute("message","All users are banned!");
        return "redirect:/admin";
    }

    @PostMapping("/unBan")
    public String unBanUserById(Long id,RedirectAttributes redirectAttributes) {
        adminService.unBanUserById(id);
        redirectAttributes.addFlashAttribute("message", "user is unbanned!");
        return "redirect:/admin";
    }

    @PostMapping("/unBanAll")
    public String unBanAll(RedirectAttributes redirectAttributes){
        adminService.unBanAllUsers();
        redirectAttributes.addFlashAttribute("message","All users are unbanned!");
        return "redirect:/admin";
    }

    @PostMapping("/deleteImagePost")
    public String deleteImagePostById(Long id,RedirectAttributes redirectAttributes){
        imagePostsService.deleteImagePost(id);
        redirectAttributes.addFlashAttribute("message","ImagePost was successfully deleted!");
        return "redirect:/admin";
    }

    @PostMapping("/deleteAllImagePosts")
    public String deleteAllImagePosts(RedirectAttributes redirectAttributes){
        imagePostsService.deleteAllImagePosts();
        redirectAttributes.addFlashAttribute("message","All imagePosts was successfully deleted!");
        return "redirect:/admin";
    }

}
