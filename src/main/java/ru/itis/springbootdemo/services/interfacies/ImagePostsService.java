package ru.itis.springbootdemo.services.interfacies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.models.ImagePost;

public interface ImagePostsService {
    ImagePost getImagePost(Long id);

    Page<ImagePost> getAllImagePosts(Pageable pageable);

    ImagePost createImagePost(ImagePostForm form, UserDTO userDTO);

    ImagePost updateImagePost(Long id, ImagePostForm form);

    void deleteImagePost(Long id);
}
