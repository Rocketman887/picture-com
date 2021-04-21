package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.dtos.mappers.ImagePostFormMapper;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.repositories.ImagePostsRepository;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

@Service
@RequiredArgsConstructor
public class ImagePostServiceImpl implements ImagePostsService {

    private final ImagePostsRepository imagePostsRepository;
    private final UsersService usersService;

    @Override
    public ImagePost getImagePost(Long id) {
        return imagePostsRepository.findById(id).get();
    }

    @Override
    public Page<ImagePost> getAllImagePosts(Pageable pageable) {
        return imagePostsRepository.findAll(pageable);
    }

    @Override
    public ImagePost createImagePost(ImagePostForm form, UserDTO userDTO) {
        ImagePost imagePost = ImagePostFormMapper.MAPPER.formToImagePost(form);
        imagePost.setUser(usersService.getUserById(userDTO.getId()));
        return imagePostsRepository.save(imagePost);
    }

    @Override
    public ImagePost updateImagePost(Long id, ImagePostForm form) {
        ImagePost imagePostForUpdate = imagePostsRepository.findById(id).get();

        imagePostForUpdate.setImagePath(form.getImagePath());
        imagePostForUpdate.setTitle(form.getTitle());
        imagePostForUpdate.setDescription(form.getDescription());
        imagePostForUpdate.setType(form.getType());

        return imagePostsRepository.save(imagePostForUpdate);
    }

    @Override
    public void deleteImagePost(Long id) {
        ImagePost imagePost = imagePostsRepository.findById(id).get();
        imagePostsRepository.delete(imagePost);
    }
}
