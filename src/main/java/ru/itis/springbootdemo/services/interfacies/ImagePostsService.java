package ru.itis.springbootdemo.services.interfacies;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;

import java.io.IOException;
import java.util.List;

public interface ImagePostsService {
    ImagePost getImagePost(Long id);

    Page<ImagePost> getAllImagePosts(Pageable pageable);

    Page<ImagePost> getImagePostsOwnedByUser(Long id,Pageable pageable);

    void createImagePost(ImagePostForm form, UserDTO userDTO, MultipartFile file) throws IOException;

    void updateImagePost(Long id, ImagePostForm form, MultipartFile file) throws IOException;

    void deleteImagePost(Long id);

    void deleteAllImagePosts();
}
