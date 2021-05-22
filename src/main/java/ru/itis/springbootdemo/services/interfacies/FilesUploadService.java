package ru.itis.springbootdemo.services.interfacies;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dtos.dtos.ImagePostDTO;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.ImagePostForm;

import java.io.IOException;

public interface FilesUploadService {
    void addImageToUser(UserDTO userDTO, MultipartFile file) throws IOException;
    String addImageToImagePost(MultipartFile file) throws IOException;
}
