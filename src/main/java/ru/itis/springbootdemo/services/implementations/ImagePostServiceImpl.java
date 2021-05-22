package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;
import ru.itis.springbootdemo.dtos.mappers.ImagePostFormMapper;
import ru.itis.springbootdemo.models.ImagePost;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.ImagePostsRepository;
import ru.itis.springbootdemo.services.interfacies.FilesUploadService;
import ru.itis.springbootdemo.services.interfacies.ImagePostsService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagePostServiceImpl implements ImagePostsService {

    private final ImagePostsRepository imagePostsRepository;
    private final UsersService usersService;
    private final FilesUploadService filesUploadService;

    @Override
    public ImagePost getImagePost(Long id) {
        return imagePostsRepository.findById(id).get();
    }

    @Override
    public Page<ImagePost> getAllImagePosts(Pageable pageable) {
        return imagePostsRepository.findAll(pageable);
    }

    @Override
    public Page<ImagePost> getImagePostsOwnedByUser(Long id, Pageable pageable) {
        return imagePostsRepository.findAllByOwner(id,pageable);
    }

    @Override
    public void createImagePost(ImagePostForm form, UserDTO userDTO, MultipartFile file) throws IOException {
        if(file!=null) {
            ImagePost imagePost = ImagePostFormMapper.MAPPER.formToImagePost(form);
            imagePost.setUser(usersService.getUserById(userDTO.getId()));
            imagePost.setImagePath(filesUploadService.addImageToImagePost(file));
            imagePostsRepository.save(imagePost);
        }
    }

    @Override
    public void updateImagePost(Long id, ImagePostForm form, MultipartFile file) throws IOException {

        ImagePost imagePostForUpdate = imagePostsRepository.findById(id).get();

        if(form.getTitle()!=null) {
            imagePostForUpdate.setTitle(form.getTitle());
        }
        if(form.getDescription()!=null) {
            imagePostForUpdate.setDescription(form.getDescription());
        }
        if(form.getType()!=null) {
            imagePostForUpdate.setType(form.getType());
        }
        if(form.getTag()!=null) {
            imagePostForUpdate.setTag(form.getTag());
        }

        if(file!=null){
            imagePostForUpdate.setImagePath(filesUploadService.addImageToImagePost(file));
        }
        imagePostsRepository.save(imagePostForUpdate);
    }

    @Override
    public void deleteImagePost(Long id) {
        imagePostsRepository.deleteById(id);
    }

    @Override
    public void deleteAllImagePosts(){
        imagePostsRepository.deleteAll();
    }
}
